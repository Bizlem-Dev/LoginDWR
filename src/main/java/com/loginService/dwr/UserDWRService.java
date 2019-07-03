package com.loginService.dwr;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.JSONException;
public class UserDWRService {
	private ResourceBundle bundle = null;
	
	public String getEduMessage(String toMonth,String toDate,String endMonth,String endDate){
//		return "dwr is wroking";
		try{
		if(Integer.parseInt(toDate) > Integer.parseInt(endDate)){
//			alert("from date should be less than to date");
			return "from date should be less than to date";	
			}else if(Integer.parseInt(toDate) == Integer.parseInt(endDate)){ 
			if(Integer.parseInt(toMonth) > Integer.parseInt(endMonth)){
//			alert("from date should be less than to date");
			return "from date should be less than to date";
			}
			}
		}catch(Exception e){
			return "false"+"~~~"+e.getMessage();
		}
		return "true";
	
	}
	
	public String getGroupAddEditMsg(String strGroupName,String strGroupSummary,String strPubRadioCh,String strPriRadioCh){
	try{
	if(strGroupName.equals("")){
//		alert("Group Name can't be blank.Please Enter Group Name");
//		document.getElementById("groupName").focus();
		return "Group Name can't be blank.Please Enter Group Name";
	}else if(strGroupSummary.equals("")){
//	alert("Group Summary can't be blank.Please Enter Group Summary");
//	document.getElementById("groupSummary").focus();
	return "Group Summary can't be blank.Please Enter Group Summary";
	}else if(!(Boolean.parseBoolean(strPubRadioCh) || Boolean.parseBoolean(strPriRadioCh))){
//	alert("Please select atleast one group access");
	return "Please select atleast one group access";
	}
	}catch(Exception e){
		return "false"+"~~~"+e.getMessage();
	}
	return "true";
	}
	
	public String getLoginFormMsg(String username,String userpass){
		try{
		if(username.equals("") && userpass.equals("")){
			return "Username and Password can't be blank";
		}else if(username.equals("")){
			return "Username can't be blank";
		}else if(!username.equals("")){
			Pattern p =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
	        Matcher m = p.matcher(username);
	        boolean bm = m.matches();
	        if(bm == false)
	        {
	        	return "This is not a valid email address";

	        }
		}
		if(userpass.equals("")){
			return "Password can't be blank";
		}
		}catch(Exception e){
			return e.getMessage();
		}
		return "true";
	}
	
	public String getSignUpUsernameMsg(String username){
		try{
			if(username.equals("")){
		    	return "Username can't be blank";
		    }
		}catch(Exception e){
			return e.getMessage();
		}
		return "true";
	}
	
	public String getSignUpEmailMsg(String strEmaiHide){
		try{
			if(strEmaiHide.equals("")){
	        	return "Email Address can't be blank";
	        }else if (!strEmaiHide.equals("")) {
	        	Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
		        Matcher objEmailM = objEmailP.matcher(strEmaiHide);
	        	boolean bemail = objEmailM.matches();
	        	if(bemail == false){
	        	return "This is not a valid email address";
	        	}else if(bemail == true){
	        		bundle = ResourceBundle.getBundle("jdbc");
	    		String[] checkparamKey = {"userId"};
	            String[] checkparamValue = {strEmaiHide};
	            									
	    		String res = callGetService(bundle.getString("usercheck"), checkparamKey, checkparamValue);
	    		if(res!=null && res.equals("true")){
	    			return "Email Id Already Exists";
	    		}
	        	}
		    }
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String checkProductModel(String url,String companyId,String strModelno){
		try{
			if(companyId.equals("")){
				return "please select atleast one company company";
			}else if(strModelno.equals("")){
				return "Enter Model Number for Product";
			}else if(!companyId.equals("") && !strModelno.equals("")){
				String[] checkparamKey = {"companyId","modelno"};
	            String[] checkparamValue = {companyId,strModelno};
	            									
	    		String res = callGetService(url, checkparamKey, checkparamValue);
	    		if(res!=null && res.equals("true")){
	    			return "Model No Already Present";
	    		}
			}
		}catch(Exception e){
			
		}
		return "true";
		
	}
	
	public String checkProductName(String data){
		try{
			if(data.equals("")){
				return "Please Enter Product Name";
			}
		}catch(Exception e){
			
		}
		return "true";
		
	}
	
	public String checkProductKeyword(String data){
		try{
			if(data.equals("")){
				return "Please Enter Keyword of Product";
			}
		}catch(Exception e){
			
		}
		return "true";
		
	}
	
	public String checkProductPrice(String data){
		try{
			if(data.equals("")){
				return "Please Enter Price of Product";
			}
		}catch(Exception e){
			
		}
		return "true";
		
	}
	
	public String checkProductCategory(String data){
		try{
			if(data.equals("")){
				return "Please Enter Category of Product";
			}
		}catch(Exception e){
			
		}
		return "true";
		
	}
	
	public String getCreateProductMsg(String strModelNo,String strProname,String strKeyword,String strPrice,String strCategory){
		try{
			if(strModelNo.equals("")){
				return "1"+"~"+"Please Enter Model No";
			}else if(strProname.equals("")){
				return "2"+"~"+"Please Enter Product Name";
			}else if(strKeyword.equals("")){
				return "3"+"~"+"Please Enter Keyword of Product";
			}else if(strPrice.equals("")){
				//return "4"+"~"+"Please Enter Price of Product";
			}else if(strCategory.equals("")){
				return "5"+"~"+"Please Enter Category of Product";
			}
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getSignUpPasswordMsg(String strPassword){
		try{
			Pattern hasUppercase = Pattern.compile("[A-Z]");
	        Pattern hasLowercase = Pattern.compile("[a-z]");
	        Pattern hasNumber = Pattern.compile("\\d");
			if(strPassword.equals("")){
	        	return "Password can't be blank";
	        }else if(strPassword.length() < 8) {
		        return "Password must contain at least eight characters!";
		      }else if(strPassword.length() > 32){
		        return "Password must be between 8 and 32 characters!";  
			  }else if(!hasNumber.matcher(strPassword).find()){
		        return "password must contain at least one number (0-9)!";
			   }else if(!hasLowercase.matcher(strPassword).find()){
		        return "password must contain at least one lowercase letter (a-z)!";
				}else if(!hasUppercase.matcher(strPassword).find()){
		        return "password must contain at least one uppercase letter (A-Z)!";
			   }	
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getSignUpCnfmPasswordMsg(String strPassword,String strConfirmPassword){
		try{
			if(strConfirmPassword.equals("")){
	        	return "Confirm Password can't be blank";
	        }else if (!strPassword.equals(strConfirmPassword)) {
				   return "password and confirm password must be same";
			   }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getSignUpMobMsg(String strMobileNo){
		try{
			String mobpattern = "\\d{0,15}";
			if(!strMobileNo.equals("") && !strMobileNo.matches(mobpattern)){
				return "mobile number should be numeric";
			   }else if(strMobileNo.length() < 9){
					return "Mobile Number should be between 9 to 15 digit";
				}else if(strMobileNo.length() > 15){
					return "Mobile Number should be between 9 to 15 digit";
				}
		}catch(Exception e){
			
		}
		return "true";
	}
	
	
	
	public String getSignUpMsg(String username,String strEmaiHide,String strPassword,String strConfirmPassword,String strMobileNo){
		try{
		Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
        Matcher objEmailM = objEmailP.matcher(strEmaiHide);
        Pattern hasUppercase = Pattern.compile("[A-Z]");
        Pattern hasLowercase = Pattern.compile("[a-z]");
        Pattern hasNumber = Pattern.compile("\\d");
//        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
        String mobpattern = "\\d{6,15}";
        System.out.println(strMobileNo.matches(mobpattern));
//        return ;
        if(username.equals("")){
        	return "Username can't be blank";
        }else if(strEmaiHide.equals("")){
        	return "Email Address can't be blank";
        }else if(strPassword.equals("")){
        	return "Password can't be blank";
        }else if(strConfirmPassword.equals("")){
        	return "Confirm Password can't be blank";
        }else if (!objEmailM.matches()) {
			return "This is not a valid email address";
	    }else if(strPassword.length() < 8) {
	        return "Password must contain at least eight characters!";
	      }else if(strPassword.length() > 32){
	        return "Password must be between 8 and 32 characters!";  
		  }else if(!hasNumber.matcher(strPassword).find()){
	        return "password must contain at least one number (0-9)!";
		   }else if(!hasLowercase.matcher(strPassword).find()){
	        return "password must contain at least one lowercase letter (a-z)!";
			}else if(!hasUppercase.matcher(strPassword).find()){
	        return "password must contain at least one uppercase letter (A-Z)!";
		   }
		   else if (!strPassword.equals(strConfirmPassword)) {
			   return "password and confirm password must be same";
		   }else if(!strMobileNo.equals("") && !strMobileNo.matches(mobpattern)){
			return "mobile number should be numeric";
		   }
		}catch(Exception e){
			return e.getMessage();
		}
		return "true";
	}
	
	public String getFromDtAddEventMsg(String fromDate){
		try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String curDate = sdf.format(date);
            Date today = sdf.parse(curDate);
            Date frmDate = sdf.parse(fromDate);
            if(frmDate.before(today)){
                return "From Date should be today or future date";
            }
        }catch(Exception ex){
           return  ex.getMessage();
        }
		return "true";
	}
	
	public String getToDtAddEventMsg(String fromDate,String toDate){
		try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(fromDate);
            Date date2 = sdf.parse(toDate);
            if(date1.after(date2)){
                return "From Date should be less than To Date";
            }
        }catch(Exception ex){
           return  ex.getMessage();
        }
		return "true";
	}
	
	public String getProfileBirthdayMsg(String birthDate){
		try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date date1 = sdf.parse(birthDate);
            //Date date2 = sdf.parse(toDate);
            String curDate = sdf.format(date);
            Date today = sdf.parse(curDate);
            if(date1.after(today)){
                return "Birth Date should be less than To Date";
            }
        }catch(Exception ex){
           return  ex.getMessage();
        }
		return "true";
	}
	
	public String callPostService(String urlStr, String[] paramName,
			String[] paramValue) {

		StringBuilder response = new StringBuilder();
		URL url;
		try {
			System.out.println("caalign callPostService");
			url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			OutputStream out = conn.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			for (int i = 0; i < paramName.length; i++) {
				writer.write(paramName[i]);
				writer.write("=");
				writer.write(URLEncoder.encode(paramValue[i], "UTF-8"));
				writer.write("&");
			}
			writer.close();
			out.close();
			if (conn.getResponseCode() != 200) {
				System.out.println("indeside caalign responce"+conn.getResponseCode());
			}
			System.out.println("caalign responce");
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			System.out.println("closinng conneciotn"+conn.getResponseCode());
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("priting responce");
		System.out.println(response.toString()+"~~~~~~~~~~~~~~~~~~~~~~~");
		return response.toString();
	}


	public String callGetService(String urlStr, String[] paramName,
			String[] paramValue) {
		URL url;
		StringBuilder requestString = new StringBuilder(urlStr);
		if (paramName != null && paramName.length > 0) {
			requestString.append("?");
			for (int i = 0; i < paramName.length; i++) {
				requestString.append(paramName[i]);
				requestString.append("=");
				requestString.append(paramValue[i]);
				requestString.append("&");
			}
		}
		StringBuilder sb = new StringBuilder();
		try {
			url = new URL(requestString.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
			}
			br.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return sb.toString();
	}

	public String getEventEmailMsg(String emailId){
		
		try{
			JSONObject strResult = new JSONObject();
			JSONArray notValidEmail = new JSONArray();
			JSONArray validEmail = new JSONArray();
			if(emailId.indexOf(",")!=-1){
			String[] arrEmail = emailId.split(",");
			//return 
			for(int i = 0 ; i < arrEmail.length ; i++ ){
				Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
		        Matcher objEmailM = objEmailP.matcher(arrEmail[i]);
	        	boolean bemail = objEmailM.matches();
	        	if(bemail == false){
	        	//return "This is not a valid email address";
	        		notValidEmail.add(arrEmail[i]);
	        	}else if(bemail == true){
	        	//return "This is not a valid email address";
	        		validEmail.add(arrEmail[i]);
	        	}
		    }
			if(notValidEmail != null && notValidEmail.size() > 0){
				strResult.put("notValidEmail",notValidEmail);
				strResult.put("validEmail",validEmail);
				return strResult.toString();
			}
		}else {
			if(!emailId.equals("")){
			Pattern objEmailP1 =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
	        Matcher objEmailM1 = objEmailP1.matcher(emailId);
        	boolean bemail1 = objEmailM1.matches();
        	if(bemail1 == false){
        	return "This is not a valid email address";
        	}
			}
			
		}
		}catch(Exception e){
			return "error---"+e.getMessage();
		}
		return "true";
	}

	
	public String getOrgNoMsg(String strOrgNo){
		try{
			if(!strOrgNo.equals("")){
			 Pattern pattern = Pattern.compile(".*[^0-9].*");
			 Matcher objP = pattern.matcher(strOrgNo);
	        	boolean b = objP.matches();
	        	if(b){
	        	return "Pincode should be number only";
	        	}
		      }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getOrgEmailMsg(String strOrgEmail){
		if (!strOrgEmail.equals("")) {
        	Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
	        Matcher objEmailM = objEmailP.matcher(strOrgEmail);
        	boolean bemail = objEmailM.matches();
        	if(bemail == false){
        	return "This is not a valid email address";
        	}
		}
		return "true";
	}
	
	public String getEventPinMsg(String strPincode){
		try{
			  if(!strPincode.equals("")){
			 Pattern pattern = Pattern.compile(".*[^0-9].*");
			 Matcher objP = pattern.matcher(strPincode);
	        	boolean b = objP.matches();
	        	if(b){
	        	return "Pincode should be number only";
	        	}
		      }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getEventCityMsg(String strCity){
		try{
			if(!strCity.equals("")){
			 Pattern pattern = Pattern.compile("[a-zA-Z]+");
			 Matcher objP = pattern.matcher(strCity);
	        	boolean b = objP.matches();
	        	if(b == false){
	        	return "City should be Alphabet only";
	        	}
		      }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getEventStateMsg(String strCity){
		try{
			if(!strCity.equals("")){
			 Pattern pattern = Pattern.compile("[a-zA-Z]+");
			 Matcher objP = pattern.matcher(strCity);
	        	boolean b = objP.matches();
	        	if(b == false){
	        	return "State should be Alphabet only";
	        	}
		      }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getEventCountryMsg(String strCity){
		try{
			if(!strCity.equals("")){
			 Pattern pattern = Pattern.compile("[a-zA-Z]+");
			 Matcher objP = pattern.matcher(strCity);
	        	boolean b = objP.matches();
	        	if(b == false){
	        	return "Country should be Alphabet only";
	        	}
		      }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getCompAddLandlineMsg(String number){
		try{
			if(!number.equals("")){
				Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
			      Matcher matcher = pattern.matcher(number);
			      
			      if (matcher.matches()) {
			    	  return "true";
			      }
			      else
			      {
			    	  return "LandLine Number must be in the form XXX-XXXXXXX and landline number should be numeric";
			      }
		      }
			
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getCompAddMobMsg(String strMobileNo){
		try{
			if(!strMobileNo.equals("")){
			String mobpattern = "\\d{0,15}";
			
			if(!strMobileNo.equals("") && !strMobileNo.matches(mobpattern)){
				return "mobile number should be numeric";
			   }else if(strMobileNo.length() < 9){
					return "Mobile Number should be between 9 to 15 digit";
				}else if(strMobileNo.length() > 15){
					return "Mobile Number should be between 9 to 15 digit";
				}
			}
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getCompAddEmailMsg(String strEmaiHide){
		try{
			if (!strEmaiHide.equals("")) {
	        	Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
		        Matcher objEmailM = objEmailP.matcher(strEmaiHide);
	        	boolean bemail = objEmailM.matches();
	        	if(bemail == false){
	        	return "This is not a valid email address";
	        	}else if(bemail == true){
	        	return "true";
	        	}
		    }
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getCompAddPinMsg(String strPincode){
		try{
			 if(!strPincode.equals("")){
			 Pattern pattern = Pattern.compile(".*[^0-9].*");
			 Matcher objP = pattern.matcher(strPincode);
	        	boolean b = objP.matches();
	        	if(b){
	        	return "Pincode should be number only";
	        	}else{
	        	//	bundle = ResourceBundle.getBundle("server");
		    		String[] checkparamKey = {"pincode"};
		            String[] checkparamValue = {strPincode};
		            		            									
		    		//String res = callGetService(bundle.getString("pincodedata"), checkparamKey, checkparamValue);
		            String res = callGetService("http://bizlem.com:8082/portal/servlet/company/show.pincodedetail", checkparamKey, checkparamValue);
		            return res;
	        	}
		      }else if(strPincode.length() < 6){
		    	  return "Pincode should be betwwen 6 to 8 digit";
				}else if(strPincode.length() > 8){
					return "Pincode should be betwwen 6 to 8 digit";
				}
			
		}catch(Exception e){
			
		}
		return "true";
	}


	public String getCompOfficialIdRes(String strEmaiHide){
		try{
			if(strEmaiHide.equals("")){
	        	return "Email Address can't be blank";
	        }else if (!strEmaiHide.equals("")) {
	        	Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
		        Matcher objEmailM = objEmailP.matcher(strEmaiHide);
	        	boolean bemail = objEmailM.matches();
	        	if(bemail == false){
	        	return "This is not a valid email address";
	        	}else if(bemail == true){
	        		String [] strSplitRes = strEmaiHide.split("@");
	        		if(strSplitRes[1].equalsIgnoreCase("gmail.com")){
	        			return "false";
	        		}else if(strSplitRes[1].equalsIgnoreCase("yahoo.com")){
	        			return "false";
	        		}else if(strSplitRes[1].equalsIgnoreCase("hotmail.com")){
	        			return "false";
	        		}else if(strSplitRes[1].equalsIgnoreCase("rediff.com")){
	        			return "false";
	        		}else if(strSplitRes[1].equalsIgnoreCase("ymail.com")){
	        			return "false";
	        		}
	        	}
		    }
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getCompAdminIdRes(String strEmaiHide){
		try{
			if(strEmaiHide.equals("")){
	        	return "Email Address can't be blank";
	        }else if (!strEmaiHide.equals("")) {
	        	Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
		        Matcher objEmailM = objEmailP.matcher(strEmaiHide);
	        	boolean bemail = objEmailM.matches();
	        	if(bemail == false){
	        	return "This is not a valid email address";
	        	}
		    }
		}catch(Exception e){
			
		}
		return "true";
	}
	
	public String getCompOffIdRes(String strEmaiHide){
		try{
			if(strEmaiHide.equals("")){
	        	return "Email Address can't be blank";
	        }else if (!strEmaiHide.equals("")) {
	        	Pattern objEmailP =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
		        Matcher objEmailM = objEmailP.matcher(strEmaiHide);
	        	boolean bemail = objEmailM.matches();
	        	if(bemail == false){
	        	return "This is not a valid email address";
	        	}
		    }
		}catch(Exception e){
			
		}
		return "true";
	}
	
}
