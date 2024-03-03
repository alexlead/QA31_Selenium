package com.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {

        String email = "artest2@artest.test";

        openRegistrationPage();
        fillCreateAccountForm(email);
        saveRegistrationForm();
        confirmRegistrationContinue();
        Assert.assertEquals(actualRegisteredEmail(), email);
    }


    @DataProvider
    public Iterator<Object[]> createAccountFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registration_list.csv")));
        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4]});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @Test(dataProvider="createAccountFromCSV")
    public void createNewAccountPositiveTestFromDataProviderFromCSV( String sex, String firstname, String lastname, String email, String password ) {

        openRegistrationPage();
        fillCreateAccountFormFromCsv(sex, firstname, lastname, email, password);
        saveRegistrationForm();
        confirmRegistrationContinue();
        String actualEmail = actualRegisteredEmail();
        clickLogoutLink();
        Assert.assertEquals(actualEmail, email);
    }

}
