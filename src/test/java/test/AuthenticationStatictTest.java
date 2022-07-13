package test;

import authenticationStatic.Authentication;
import authenticationStatic.CredentialsStaticService;
import authenticationStatic.PermissionStaticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class AuthenticationStatictTest {
    private Authentication authentication= new Authentication();
    @Test
    public void loginOkStatic(){
        String user = "aaa";
        String pwd = "ss";
        MockedStatic<CredentialsStaticService> credentialsMocked = Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> permissionMocked = Mockito.mockStatic(PermissionStaticService.class);
        credentialsMocked.when(() -> CredentialsStaticService.isValidCredential(user, pwd)).thenReturn(true);
        permissionMocked.when(()->PermissionStaticService.getPermission(user)).thenReturn("CRUD");
        Assertions.assertTrue(CredentialsStaticService.isValidCredential(user,pwd),authentication.login(user,pwd));
        System.out.println(authentication.login(user,pwd));
    }
    @Test
    public void loginInvalidoStatic(){
        String user = "aaa";
        String pwd = "ss";
        MockedStatic<CredentialsStaticService> credentialsMocked = Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> permissionMocked = Mockito.mockStatic(PermissionStaticService.class);
        credentialsMocked.when(() -> CredentialsStaticService.isValidCredential(user, pwd)).thenReturn(false);
        permissionMocked.when(()->PermissionStaticService.getPermission(user)).thenReturn("CRUD");
        Assertions.assertFalse(CredentialsStaticService.isValidCredential(user,pwd),authentication.login(user,pwd));
        System.out.println(authentication.login(user,pwd));
    }

}
