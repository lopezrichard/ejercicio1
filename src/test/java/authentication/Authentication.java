package authentication;

import authenticationStatic.CredentialsStaticService;
import authenticationStatic.PermissionStaticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class Authentication {
    private PermissionService permissionService;
    private CredentialsService credentialsService;

    public Authentication(PermissionService permisos,CredentialsService credenciales){
        permissionService=permisos;
        credentialsService= credenciales;
    }

    public String login(String user, String pwd){

        if (credentialsService.isValidCredential(user,pwd)){
            String permission=permissionService.getPermission(user);
            return "user authenticated successfully with permission: ["+permission+"]";
        }else{
            return "user or password incorrect";
        }
    }




}
