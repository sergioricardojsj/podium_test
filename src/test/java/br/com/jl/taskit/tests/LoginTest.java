package br.com.jl.taskit.tests;

import br.com.jl.taskit.listeners.InvokedMethodListener;
import br.com.jl.taskit.pages.HomePage;
import br.com.jl.taskit.pages.LoginPage;
import br.com.jl.taskit.settings.RetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ InvokedMethodListener.class })
public class LoginTest extends BaseTestCase {

    @Test( retryAnalyzer = RetryAnalyzer.class )
    public void shouldLoginSuccessfully() {
        new LoginPage().fillLoginField().validateLogin();
    }

    @Test( retryAnalyzer = RetryAnalyzer.class )
    public void shouldLogOffSucessfully() {
        new LoginPage().fillLoginField().validateLogin();
        new HomePage().logout().validateLogout();
    }

}
