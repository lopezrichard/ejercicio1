package test;

import authentication.Authentication;
import authentication.CredentialsService;
import authentication.PermissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class AuthenticationTest {
    private PermissionService permissionMockito= Mockito.mock(PermissionService.class);
    private CredentialsService credentialsMockito= Mockito.mock(CredentialsService.class);

    @Test
    public void loginOk(){
        String user = "aaa";
        String pwd = "ss";
        Mockito.when(credentialsMockito.isValidCredential(user,pwd)).thenReturn(true);
        Mockito.when(permissionMockito.getPermission(user)).thenReturn("CRUD");
        Authentication authentication= new Authentication(permissionMockito,credentialsMockito);
        Assertions.assertTrue(credentialsMockito.isValidCredential(user,pwd), authentication.login(user,pwd));
        System.out.println(authentication.login(user,pwd));
    }
    @Test
    public void loginInvalido(){
        String user = "aaa";
        String pwd = "ss";
        Mockito.when(credentialsMockito.isValidCredential(user,pwd)).thenReturn(false);
        Mockito.when(permissionMockito.getPermission(user)).thenReturn("CRUD");
        Authentication authentication= new Authentication(permissionMockito,credentialsMockito);
        Assertions.assertFalse(credentialsMockito.isValidCredential(user,pwd), authentication.login(user,pwd));
        System.out.println(authentication.login(user,pwd));

    }
}
