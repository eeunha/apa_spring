package com.project.apa.api.pharmacy.controller;

import com.project.apa.api.pharmacy.domain.DispenseDTO;
import com.project.apa.api.pharmacy.domain.PharmacyInfoDTO;
import com.project.apa.api.pharmacy.service.DispenseService;
import com.project.apa.api.pharmacy.service.PharmacyInfoService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/pharmacy/{id}")
public class RestPharmacyController {
	private static final Logger logger = Logger.getLogger(RestPharmacyController.class.getName());

	@Autowired
	private PharmacyInfoService pharmacyInfoService;
    
	@Autowired
    private DispenseService dispenseService;


    //약국정보 가져오기
	 @GetMapping("/info")
	  public @ResponseBody PharmacyInfoDTO getPharmacyInfo(@PathVariable String id) {
	        return pharmacyInfoService.getPharmacyInfo(id);
	 }
	  
	  //약국운영정보 가져오기
	 @GetMapping("/opening")
	  public @ResponseBody PharmacyInfoDTO getPharmacyOpeningInfo(@PathVariable String id) {
		  return pharmacyInfoService.getPharmacyOpeningInfo(id);
	 }
	  
    //전체제조목록 가져오기
    @GetMapping("/dispenselist")
    public List<DispenseDTO> getDispenseList(@PathVariable String id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		int pageSize = 10;
		int begin = (page - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		
		return dispenseService.getDispenseList(id, begin, end);
    }
    
	/*
	 * //전체제조목록 최신순으로 보기
	 * 
	 * @GetMapping("/dispenselistlatest") public List<DispenseDTO>
	 * dispensesLatest(Model model, @RequestParam("id") String id) { //
	 * appointmentDate를 기준으로 내림차순으로 정렬된 데이터 가져오기 List<DispenseDTO> dispensesLatest =
	 * dispenseService.getDispensesLatest(id);
	 * 
	 * // 모델에 정렬된 데이터를 추가하여 뷰에 전달 model.addAttribute("dispensesLatest",
	 * dispensesLatest);
	 * 
	 * return dispenseService.getDispensesLatest(id); // 실제 뷰의 이름에 맞게 설정해야 합니다. }
	 */
    
  //제조대기목록 가져오기
    @GetMapping("/dispensewaiting")
    public List<DispenseDTO> getDispenseWaiting(@PathVariable String id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		int pageSize = 10;
		int begin = (page - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		
		return dispenseService.getDispenseWaiting(id, begin, end);
    }
    
    
   //여기가 잘못된듯? 배열을 못받나?
  //제조 대기 승인/거부    
    @PutMapping("/dispensewaiting")
    public ResponseEntity<String> dispenseAction(
            @PathVariable String id
            ,@RequestBody Map<String, String> data
            ) {
    	//logger.info("--------------------dispensewaiting START----------------------");
    	//logger.info("input:" + data);
    	String action = data.get("action");
    	List<Integer> dispenseIds = new ArrayList<Integer>();
    	
    	for(String dispense: data.get("dispenseIds").split(",")) {
    		dispenseIds.add(Integer.parseInt(dispense));
    	}
    	
        boolean success =true;
        String message;

       
        //logger.info("dispenseIds:" + dispenseIds);
        if (action.equals("approve")) {
            success = dispenseService.approveDispense(dispenseIds);
            message = "성공적으로 승인되었습니다.";
        } else if (action.equals("reject")) {
            success = dispenseService.rejectDispense(dispenseIds);
            message = "성공적으로 거절되었습니다.";
        } else {
            return ResponseEntity.badRequest().body("Action Type Error");
        }
        //logger.info("success:" + success);
        //logger.info("--------------------dispensewaiting END----------------------");
        if (success) {
            return ResponseEntity.ok("선택한 처방내역이 성공적으로 " + message + "되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            		.body("dispensewaiting error");
        }
       
    }
    
    
    
  //제조중목록 가져오기
    @GetMapping("/dispensing")
    public List<DispenseDTO> getDispensing(@PathVariable String id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		int pageSize = 10;
		int begin = (page - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		
		return dispenseService.getDispensing(id, begin, end);
    }
    
  //제조중 > 제조완료 처리하기  
   @PutMapping("/dispensing") 
   public ResponseEntity<String> dispensingAction(
           @PathVariable String id
           ,@RequestBody Map<String, String> data
           ) {
   	//logger.info("--------------------dispensing START----------------------");
   	//logger.info("input:" + data);
   	String action = data.get("action");
   	List<Integer> dispenseIds = new ArrayList<Integer>();
   	
   	for(String dispense: data.get("dispenseIds").split(",")) {
   		dispenseIds.add(Integer.parseInt(dispense));
   	}
   	
       boolean success =true;
       String message;

      
       //logger.info("dispenseIds:" + dispenseIds);
       if (action.equals("finish")) {
           success = dispenseService.finishDispense(dispenseIds);
           message = "성공적으로 처리되었습니다.";       
       } else {
           return ResponseEntity.badRequest().body("Action Type Error");
       }
       //logger.info("success:" + success);
       //logger.info("--------------------dispensing END----------------------");
       if (success) {
           return ResponseEntity.ok("선택한 처방내역이 성공적으로 " + message + "되었습니다.");
       } else {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
           		.body("dispensing error");
       }
      
   } 
    
    
    
  //제조완료목록 가져오기
    @GetMapping("/dispensecomplete")
    public List<DispenseDTO> getDispenseComplete(@PathVariable String id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		int pageSize = 10;
		int begin = (page - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		
		return dispenseService.getDispenseComplete(id, begin, end);
    }
    
  //제조완료 >  수령완료 처리하기    
  @PutMapping("/dispensecomplete")
  public ResponseEntity<String> dispenseFinishAction(
          @PathVariable String id
          ,@RequestBody Map<String, String> data
          ) {
  	//logger.info("--------------------dispensing START----------------------");
  	//logger.info("input:" + data);
  	String action = data.get("action");
  	List<Integer> dispenseIds = new ArrayList<Integer>();
  	
  	for(String dispense: data.get("dispenseIds").split(",")) {
  		dispenseIds.add(Integer.parseInt(dispense));
  	}
  	
      boolean success =true;
      String message;

     
      //logger.info("dispenseIds:" + dispenseIds);
      if (action.equals("pickUpfinish")) {
          success = dispenseService.pickUpFinishDispense(dispenseIds);
          message = "성공적으로 처리되었습니다.";       
      } else {
          return ResponseEntity.badRequest().body("Action Type Error");
      }
      //logger.info("success:" + success);
      //logger.info("--------------------dispensing END----------------------");
      if (success) {
          return ResponseEntity.ok("선택한 처방내역이 성공적으로 " + message + "되었습니다.");
      } else {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          		.body("dispensing error");
      }
     
  }  
    
    
  //수령완료 목록 가져오기
    @GetMapping("/dispensepickup")
    public List<DispenseDTO> getDispensePickUp(@PathVariable String id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		int pageSize = 10;
		int begin = (page - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		
		return dispenseService.getDispensePickUp(id, begin, end);
    }
    
}
