package Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class MyActionListener implements ActionListener {
    MyFrame fFrame;
    public MyActionListener(MyFrame f)
    {
        fFrame = f;
    }

    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()){
            case ("C"):
                fFrame.TextList.clear();
                break;
            case ("X^2"):
                if (fFrame.TextList.size() != 0)
                    fFrame.TextList.set(-1, fFrame.TextList.get(-1) + "^2");
                break;
            case ("SQRT X"):
                if (fFrame.TextList.size() != 0)
                    fFrame.TextList.set(-1, "SQRT(" + fFrame.TextList.get(-1) + ")");
                break;
            case ("/"):
                fFrame.TextList.add("/");
                break;
            case ("7"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"7");
                else
                    fFrame.TextList.add("7");
                break;
            case ("8"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"8");
                else
                    fFrame.TextList.add("8");
                break;
            case ("9"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"9");
                else
                    fFrame.TextList.add("9");
                break;
            case ("*"):
                fFrame.TextList.add("*");
                break;
            case ("4"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"4");
                else
                    fFrame.TextList.add("4");
                break;
            case ("5"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"5");
                else
                    fFrame.TextList.add("5");
                break;
            case ("6"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"6");
                else
                    fFrame.TextList.add("6");
                break;
            case ("-"):
                fFrame.TextList.add("-");
                break;
            case ("1"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"1");
                else
                    fFrame.TextList.add("1");
                break;
            case ("2"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"2");
                else
                    fFrame.TextList.add("2");
                break;
            case ("3"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"3");
                else
                    fFrame.TextList.add("3");
                break;
            case ("+"):
                fFrame.TextList.add("+");
                break;
            case ("Erase"):
                if (fFrame.TextList.size() != 0)
                    fFrame.TextList.remove(fFrame.TextList.lastIndex());
                break;
            case ("0"):
                if (fFrame.TextList.size() != 0 &&
                        fFrame.TextList.get(-1).matches("(([-+])?[0-9]+(\\.+)?)+"))
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+"0");
                else
                    fFrame.TextList.add("0");
                break;
            case ("."):
                if (fFrame.TextList.size() != 0)
                    fFrame.TextList.set(-1,fFrame.TextList.get(-1)+".");
                break;
            case ("="):
                break;
            default:
                break;
        }

        fFrame.fText.AddList(fFrame.TextList);
    }
}

class MyArrayList extends ArrayList<String> {

    MyArrayList(){};

    @Override
    public String get(int index) {
        if (index == -1 && this.size() != 0)
            return super.get(lastIndex());
        else
            return super.get(index);
    }

    @Override
    public String set(int index, String element) {
        if (index == -1 && this.size() != 0)
            return super.set(lastIndex(), element);
        else
            return super.set(index, element);
    }

    public int lastIndex(){
        if (this.size() != 0)
            return this.size()-1;
        else
            return 0;
    }
}

class MyFrame extends Frame {

    private GridLayout fGrid;
    protected MyArrayList TextList = new MyArrayList();
    protected MyTextField fText = new MyTextField();

    public MyFrame(){

        fText.setEditable(false);

        Panel fPanel1 = new Panel();
        Panel fPanel2 = new Panel();

        add(fPanel1, BorderLayout.NORTH);
        add(fPanel2, BorderLayout.CENTER);

        fPanel1.setLayout(new BorderLayout());
        fPanel2.setLayout(new GridLayout(6,4));

        Button[] fButton = new Button[20];

        fButton[0] = new Button("C");
        fButton[0].setActionCommand("C");
        fButton[0].addActionListener(new MyActionListener(this));

        fButton[1] = new Button("X^2");
        fButton[1].setActionCommand("X^2");
        fButton[1].addActionListener(new MyActionListener(this));

        fButton[2] = new Button("SQRT X");
        fButton[2].setActionCommand("SQRT X");
        fButton[2].addActionListener(new MyActionListener(this));

        fButton[3] = new Button("/");
        fButton[3].setActionCommand("/");
        fButton[3].addActionListener(new MyActionListener(this));

        fButton[4] = new Button("7");
        fButton[4].setActionCommand("7");
        fButton[4].addActionListener(new MyActionListener(this));

        fButton[5] = new Button("8");
        fButton[5].setActionCommand("8");
        fButton[5].addActionListener(new MyActionListener(this));

        fButton[6] = new Button("9");
        fButton[6].setActionCommand("9");
        fButton[6].addActionListener(new MyActionListener(this));

        fButton[7] = new Button("*");
        fButton[7].setActionCommand("*");
        fButton[7].addActionListener(new MyActionListener(this));

        fButton[8] = new Button("4");
        fButton[8].setActionCommand("4");
        fButton[8].addActionListener(new MyActionListener(this));

        fButton[9] = new Button("5");
        fButton[9].setActionCommand("5");
        fButton[9].addActionListener(new MyActionListener(this));

        fButton[10] = new Button("6");
        fButton[10].setActionCommand("6");
        fButton[10].addActionListener(new MyActionListener(this));

        fButton[11] = new Button("-");
        fButton[11].setActionCommand("-");
        fButton[11].addActionListener(new MyActionListener(this));

        fButton[12] = new Button("1");
        fButton[12].setActionCommand("1");
        fButton[12].addActionListener(new MyActionListener(this));

        fButton[13] = new Button("2");
        fButton[13].setActionCommand("2");
        fButton[13].addActionListener(new MyActionListener(this));

        fButton[14] = new Button("3");
        fButton[14].setActionCommand("3");
        fButton[14].addActionListener(new MyActionListener(this));

        fButton[15] = new Button("+");
        fButton[15].setActionCommand("+");
        fButton[15].addActionListener(new MyActionListener(this));

        fButton[16] = new Button("Erase");
        fButton[16].setActionCommand("Erase");
        fButton[16].addActionListener(new MyActionListener(this));

        fButton[17] = new Button("0");
        fButton[17].setActionCommand("0");
        fButton[17].addActionListener(new MyActionListener(this));

        fButton[18] = new Button(".");
        fButton[18].setActionCommand(".");
        fButton[18].addActionListener(new MyActionListener(this));

        fButton[19] = new Button("=");
        fButton[19].setActionCommand("=");
        fButton[19].addActionListener(new MyActionListener(this));

        fPanel1.add(fText);
        for (int i = 0; i < 20; i++)
            fPanel2.add(fButton[i]);

        addWindowListener(new MyWindowAdapter(this));

    }

}

class MyTextField extends TextField{

    MyTextField(){
        setText("");
    }

    void AddList(ArrayList<String> Text){
        setText("");

        StringBuilder AllText = new StringBuilder();
        for (String s: Text){
            AllText.append(s);
        }

        this.setText(AllText.toString());

    }

}

class MyWindowAdapter extends WindowAdapter {
    Frame fFrame;
    public MyWindowAdapter(Frame f)
    {
        fFrame = f;
    }

    public void windowClosing(WindowEvent we)
    {
        System.out.println("Closing window...");
        fFrame.setVisible(false);
        System.out.println("Exiting system...");
        System.exit(0);
    }
}

class Server implements IServer{
    MyFrame f;

    public Server(){
        f = new MyFrame();
        f.setTitle("Calculation");
        f.setSize(500,500);
    }

    public void WindowLaunch(){
        f.setVisible(true);
    }
}
