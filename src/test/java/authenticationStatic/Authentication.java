package authenticationStatic;

import authentication.CredentialsService;
import authentication.PermissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class Authentication {


    public Authentication(){
    }



    public String login(String user, String pwd){
        if (CredentialsStaticService.isValidCredential(user,pwd)){
            String permission=PermissionStaticService.getPermission(user);
            return "user authenticated successfully with permission: ["+permission+"]";
        }else{
            return "user or password incorrect";
        }
    }



    }
