<!DOCTYPE suite SYSTEM"http://testng.org/testng-1.0.dtd">

<suite name="Reg"verbose="1">

    <groups>
        <run>
            <include name="web"/>
        </run>
    </groups>

    <test name="Reg">
      <classes>
         <class name="tests.RegistrationTest"/>
         <class name="tests.LoginTest"/>
     </classes>
    </test>
</suite>