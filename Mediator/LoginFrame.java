import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.Gridlayout;
import java.awt.ActionListner;
import java.awt.ActionEvent;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleague();

        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged();
        pack();
        show();
    }

    public void createColleague() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(buttonOk);
        buttonCancel.addActionListener(buttonCancel);
    }

public void colleagueChanged(){
    if(checkGuest.getState()){
        textUser.setColleagueEnabled(false);
        textPass.setColleagueEnabled(false);
        buttonOk.setColleagueEnabled(true);
    }
    else{
        textUser.setColleagueEnabled(true);
        userpassChanged();
    }
}

    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            buttonOk.setColleagueEnabled(true);
        }
        if (textUser.getText().length() > 0) {
            buttonOk.setColleagueEnabled(false);
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("LoginFrame: Action performed " + e.getActionCommand());
    }
}