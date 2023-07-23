import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


class PassGene extends JFrame {
       Container c;
     
      JToggleButton upperCase , lowerCase , numbers,symbols;
      JLabel passL , heading;
      JTextField passLength ,txtResult;
      JButton generator;
  

     private PassWordGenerator passWordGenerator;

      PassGene() {

         c = getContentPane();
        c.setLayout(null);

        JLabel heading = new JLabel("Password Generator");
        JTextField txtResult = new JTextField();
        JLabel passL = new JLabel("Password Length");
        JTextField passLength = new JTextField();
         upperCase = new JToggleButton("UpperCase");
         lowerCase = new JToggleButton("LowerCase");
         numbers = new JToggleButton("Numbers");
          symbols = new JToggleButton("Symbols");
         generator= new JButton("Generate");

        Font f = new Font("Arial", Font.BOLD, 20);
        heading.setFont(f);
        txtResult.setFont(f);
        passL.setFont(f);
        passLength.setFont(f);
        upperCase.setFont(f);
        lowerCase.setFont(f);
        numbers.setFont(f);
        symbols.setFont(f);
        generator.setFont(f);
    
heading.setBounds(100,20,400,30);
txtResult.setBounds(10,50,370,50);
passL.setBounds(10,130,270,30);
passLength.setBounds(180,120,200,50);
upperCase.setBounds(10,200,180,50);
lowerCase.setBounds(200,200,180,50);
numbers.setBounds(10,270,180,50);
symbols.setBounds(200,270,180,50);
generator.setBounds(120,350,150,50);


         c.add(heading);
         c.add(txtResult);
         c.add(passL);
         c.add(passLength);
         c.add(upperCase);
         c.add(lowerCase);
         c.add(numbers);
         c.add(symbols);
         c.add(generator);



           
         generator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                passWordGenerator = new PassWordGenerator();
                 if(passLength.getText().length() <=0) return;
                 boolean anyToggleSelected = lowerCase.isSelected() || upperCase.isSelected() || numbers.isSelected() || symbols.isSelected();

                 int passwordLength = Integer.parseInt((passLength.getText()));
                  

                 if(anyToggleSelected)
                 {
                    String generatedPassword = passWordGenerator.generatePassWord(passwordLength, upperCase.isSelected(), lowerCase.isSelected(), numbers.isSelected(), symbols.isSelected());



                    txtResult.setText(generatedPassword);
                 }

            }
         });



       
        
        setTitle("PasswordGenerator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

      }

    

}


 class PassWordGenerator  {
     
     public static final String LOWERCASE_CHARACTER="abcdefghijklmnopqrstuvwxyz";
     public static final String UPPERCASE_CHARACTER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     public static final String NUMBERS="0123456789";
     public static final String SPECIAL_SYMBOLS="!@#$%^&*()-_+={}[]:;,<>./?|";
     

     private final Random random;

          PassWordGenerator()
          {
                 
             random = new Random();

          }

    public String generatePassWord(int length, boolean includeUppercase , boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbole ) 
    
    {
             StringBuilder passwordBuilder = new StringBuilder();

                  
             String validCharacters= "";
             if(includeUppercase)
             {
                validCharacters += UPPERCASE_CHARACTER;
             }
             if(includeLowercase)
             {
                validCharacters += LOWERCASE_CHARACTER;
             }
             if(includeNumbers)
             {
                validCharacters += NUMBERS;
             }
             if(includeSpecialSymbole)
             {
                validCharacters += SPECIAL_SYMBOLS;
             }


             for(int i = 0 ; i<length ; i++)
             {
                int randomIndex = random.nextInt(validCharacters.length());


                char randChar = validCharacters.charAt(randomIndex);
                  
                passwordBuilder.append(randChar);

                

             }

             return passwordBuilder.toString();
    }





}



public class P1 {

    public static void main(String[] args) {
        
        
        PassGene pg = new PassGene();


        
    
    }
    
}
