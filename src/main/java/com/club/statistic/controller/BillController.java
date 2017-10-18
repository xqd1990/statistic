package com.club.statistic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javassist.expr.Instanceof;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.club.statistic.entity.Bill;
import com.club.statistic.service.BillService;
import com.club.statistic.service.PlayerService;

@Controller
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/show")
	public String bill(){
		return "bill";
	}
	@RequestMapping("/end")
	public String end(){
		return "query";
	}
	
	@RequestMapping("/query")
	public @ResponseBody List<Bill> query(HttpServletRequest req, String start, String end){
		start = start + " 00:00:00";
		end = end + " 23:59:59";
		List<Bill> bills = billService.getBills(start, end);
		Collections.sort(bills, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				int flag = 0;
				if(o1 instanceof Bill && o2 instanceof Bill){
					Bill bill1 = (Bill)o1;
					Bill bill2 = (Bill)o2;
					flag = bill1.getFinish_time().compareTo(bill2.getFinish_time());
				}
				return flag;
			}
		});
		return bills;
	}
	
	@RequestMapping("/pay")
	@ResponseBody
	public String pay_for_ids(@RequestBody String[] array){
		billService.billPay(array);
		return "success";
	}
	
	@RequestMapping("/cancel")
	@ResponseBody
	public String cancel_for_ids(@RequestBody String[] array){
		billService.billCancel(array);
		return "success";
	}
	
	@RequestMapping("/in")
	@ResponseBody
	public String in(HttpServletRequest req){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> files = null;
		try {
			files = upload.parseRequest(req);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bill> bills = new ArrayList<Bill>();
		for(FileItem file:files){
			if(!file.isFormField()){
				InputStream is = null;
				try {
					is = file.getInputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Workbook wb = null;
				try {
					wb = Workbook.getWorkbook(is);
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Sheet sheet = wb.getSheet(0);
				int count = sheet.getRows();
				for(int i=1;i<count;i++){
					if("655555".equals(sheet.getCell(9, i).getContents())){
						Bill bill = new Bill();
						bill.setDesk(sheet.getCell(1, i).getContents());
						bill.setPlayer(playerService.getPlayerById(sheet.getCell(7, i).getContents()));
						bill.setFinish_time(sheet.getCell(19, i).getContents());
						bill.setSocre(Integer.valueOf(sheet.getCell(18, i).getContents()));
						bill.setInsurance(Integer.valueOf(sheet.getCell(15, i).getContents()));
						bills.add(bill);
					}
				}
			}
		}
		try{
			billService.billIn(bills);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
}
