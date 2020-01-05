/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SMS {
  private String ACCOUNT_SID;
  private String AUTH_TOKEN;

  public SMS() {
     ACCOUNT_SID ="AC6e27f78da5434856b67f06296d811847"; 
     AUTH_TOKEN = "8209bb4734895b058302d5afc8d9968a";
  }
  
  
  public void enviar(int telefono, String codigo){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber("+506"+telefono),
        new PhoneNumber("+15103446397"), 
        "Su codigo de verificacion de sala es: "+codigo).create();
    System.out.println(message.getSid());
  } 
    
}
