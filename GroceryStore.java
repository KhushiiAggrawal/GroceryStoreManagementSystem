package grocerystore;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.table.DefaultTableCellRenderer;


public class GroceryStore {
    public static String[][] getRows(){
        String rowData[][] = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
        Statement stmt=con.createStatement();
        String query="select * from grocerystore";
        String countQuery="select count(pid) from grocerystore";//for counting number of rows in database
        ResultSet rs=stmt.executeQuery(countQuery);
        rs.next();
        Integer count=Integer.parseInt(rs.getString(1));
        System.out.println(count);
        rs=stmt.executeQuery(query);
        int i=0;
        
        String rows[][]=new String[count][3];
        while(rs.next()){
//            System.out.println("cid "+rs.getInt(1)+" name "+rs.getString(2)+" location "+rs.getString(3));
            String []data={Integer.toString(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getDate(6).toString(),rs.getDate(7).toString(),rs.getString(5),Integer.toString(rs.getInt(9)),rs.getString(8)};
            rows[i]=data;
            i++;   
          }
        
        rowData=rows;
        con.close();
        }
        catch(Exception e){e.printStackTrace();}
        
        return rowData;
    }
    public static void addRowGui(String [][]rows){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
            JFrame addFrame=new JFrame("Insert Item");
            addFrame.setSize(600,450);
            addFrame.setLocationRelativeTo(null);
            addFrame.setResizable(false);
            addFrame.setVisible(true);
            addFrame.setLayout(null);
            JLabel productname=new JLabel("Product Name:");
            JLabel category=new JLabel("Category");
            JLabel batchno=new JLabel("Batch No.");
            JLabel quantity=new JLabel("Quanitity:");
            JLabel mfg=new JLabel("Mfg Date");
            JLabel exp=new JLabel("Exp Date");
            JLabel mrp=new JLabel("M.R.P");
            JLabel description=new JLabel("Product Description");

            productname.setBounds(10,10,120,18);
            category.setBounds(10,35,120,18);
            batchno.setBounds(10,60,120,18);
            quantity.setBounds(320,60,120,18);
            mfg.setBounds(10,85,120,18);
            exp.setBounds(320,85,120,18);
            mrp.setBounds(10,110,120,18);
            description.setBounds(10,135,120,18);
            addFrame.add(productname);
            addFrame.add(category);
            addFrame.add(batchno);
            addFrame.add(quantity);
            addFrame.add(mfg);
            addFrame.add(exp);
            addFrame.add(mrp);
            addFrame.add(description);
            
            JTextField nameField=new JTextField();
            JTextField CategoryField=new JTextField();
            JTextField batchField=new JTextField();
            JTextField quantityField=new JTextField();
            JTextField expField=new JTextField();
            JTextField mfgField=new JTextField();
            JTextField mrpField=new JTextField();
            
            JTextArea descField=new JTextArea();
            nameField.setBounds(140,10,360,18);
            CategoryField.setBounds(140,35,360,18);
            batchField.setBounds(140,60,120,18);
            quantityField.setBounds(380,60,120,18);
            mfgField.setBounds(140,85,120,18);
            expField.setBounds(380,85,120,18);
            mrpField.setBounds(140,110,120,18);
            descField.setBounds(140,135,360,220);
            addFrame.add(nameField);
            addFrame.add(CategoryField);
            addFrame.add(batchField);
            addFrame.add(quantityField);
            addFrame.add(mfgField);
            addFrame.add(expField);
            addFrame.add(mrpField);
            addFrame.add(descField);
            JButton addbtn=new JButton("INSERT");
            addbtn.setBounds(240,370,90,30);
            addFrame.add(addbtn);
            addbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                String name=nameField.getText();
                String category=CategoryField.getText();
                String batchno=batchField.getText();
                String quantity=quantityField.getText();
                String mfg=mfgField.getText();
                String exp=expField.getText();
                String mrp=mrpField.getText();
                String desc=descField.getText();
                if(!name.equals("")&&!category.equals("")&&!desc.equals("")){
                PreparedStatement pstmt= con.prepareStatement("insert into grocerystore(productname,category,batchno,quantity,mfgdate,expdate,description,mrp)values(?,?,?,?,?,?,?,?)");
                pstmt.setString(1,name);
                pstmt.setString(2,category);   
                pstmt.setString(3,batchno);  
                pstmt.setString(4,quantity);  
                pstmt.setString(5,mfg);  
                pstmt.setString(6,exp);  
                pstmt.setString(7,desc); 
                pstmt.setString(8,mrp);  
                pstmt.executeUpdate();
                System.out.println("ROW INSERTED");
                addFrame.dispose();
                mainGui(getRows());
                con.close();
                }
                }catch(Exception err){err.printStackTrace();}
            }
        });
            addFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    mainGui(getRows());
                }
            });
            
        }catch(Exception e){e.printStackTrace();}
    }
    public static void viewGui(String pid,String [][]rows)throws SQLException{
        try{
        Color c;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
        Statement stmt=con.createStatement();
        String query="select * from grocerystore where pid="+pid;
        ResultSet rs=stmt.executeQuery(query);
        rs.next();
        System.out.println(rs.getString(2));
        JFrame selectFrame=new JFrame(rs.getString(2));
        selectFrame.setSize(700,600);
        selectFrame.setLocationRelativeTo(null);
        selectFrame.setResizable(false);
        selectFrame.setVisible(true);
        selectFrame.setLayout(null);
        
        //delete and back Button
        JButton delete=new JButton("Delete");
        delete.setBounds(495,526,80,30);
        JButton back=new JButton("Back");
        back.setBounds(585,526,80,30);
        back.setBackground(Color.YELLOW);
        selectFrame.add(back);
        selectFrame.add(delete);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                mainGui(getRows());
            }
        } );
        //name panel
        JPanel namePanel=new JPanel();
         c = new Color(231,171,134);
        namePanel.setBackground(c);
        namePanel.setBounds(0,0,700,80);
        namePanel.setLayout(null);
        
        //detail panel
        JPanel DetailPanel=new JPanel();
        DetailPanel.setBounds(0,70,700,160);
        DetailPanel.setLayout(null);
        
        //product name
        JLabel name=new JLabel(rs.getString(2));
        name.setBounds(200,10,300,50);
        name.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        //product Quantity
        JLabel QuantityLabel=new JLabel("Net Quantity :");
        JLabel Quantity=new JLabel(rs.getString(5));
        Quantity.setBounds(150,15,600,24);
        Quantity.setFont(new Font("Serif", Font.PLAIN, 18));
        QuantityLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        QuantityLabel.setBounds(10,15,200,24);
        
        //product batchno.
        JLabel BatchLabel=new JLabel("Batch No. :");
        JLabel batch=new JLabel(rs.getString(4));
        batch.setBounds(150,45,600,24);
        batch.setFont(new Font("Serif", Font.PLAIN, 18));
        BatchLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        BatchLabel.setBounds(10,45,100,24);
        
        //product mfgdate
        JLabel mfgLabel=new JLabel("Manufactured Date:");
        JLabel mfg=new JLabel(rs.getString(6));
        mfg.setBounds(150,75,600,24);
        mfg.setFont(new Font("Serif", Font.PLAIN, 18));
        mfgLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        mfgLabel.setBounds(10,75,200,24);
        
        //product expdate
        JLabel expLabel=new JLabel("Expiring Date :");
        JLabel exp=new JLabel(rs.getString(7));
        exp.setBounds(150,105,600,24);
        exp.setFont(new Font("Serif", Font.PLAIN, 18));
        expLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        expLabel.setBounds(10,105,200,24);
        namePanel.add(name);
        
        
        //product mrp
        JLabel MrpLabel=new JLabel("M.R.P :");
        JLabel Mrp=new JLabel(rs.getString(9)+" Rs." );
        Mrp.setBounds(150,135,600,24);
        Mrp.setFont(new Font("Serif", Font.PLAIN, 18));
        MrpLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        MrpLabel.setBounds(10,135,100,24);
        
        //product Description
        JPanel descPanel=new JPanel();
        descPanel.setBounds(0,210,700,500);
        descPanel.setLayout(null);
        JLabel descLabel=new JLabel("Description");
        descLabel.setBounds(10,40,100,20);
        descLabel.setFont(new Font("Serif", Font.BOLD, 18));
        descPanel.add(descLabel);
        JTextArea desc=new JTextArea(rs.getString(8));
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setEditable(false);
        desc.setBackground(Color.WHITE);
        desc.setFont(new Font("Serif", Font.PLAIN, 18));       
        JScrollPane scroll =new JScrollPane(desc);
        scroll.setBounds(15,65,656,250);
        descPanel.add(scroll);
        
        //
        DetailPanel.add(batch);
        DetailPanel.add(BatchLabel);
        DetailPanel.add(Quantity);
        DetailPanel.add(QuantityLabel);
        DetailPanel.add(Mrp);
        DetailPanel.add(MrpLabel);
        DetailPanel.add(mfg);
        DetailPanel.add(mfgLabel);
        DetailPanel.add(exp);
        DetailPanel.add(expLabel);
        //
        selectFrame.add(namePanel);
        selectFrame.add(DetailPanel);
        selectFrame.add(descPanel);
        
        //
        JButton editName=new JButton("Edit");
        JButton editBatchno=new JButton("Edit");
        JButton editQuantity=new JButton("Edit");
        JButton editMrp=new JButton("Edit");
        JButton editmfgdate=new JButton("Edit");
        JButton editexpdate=new JButton("Edit");
        JButton editDesc=new JButton("Edit");
        
       
        editName.setBounds(620,5,60,18);
        editQuantity.setBounds(610,20,60,18);
        editBatchno.setBounds(610,50,60,18);
        editmfgdate.setBounds(610,80,60,18);
        editexpdate.setBounds(610,110,60,18);
        editMrp.setBounds(610,140,60,18);
        editDesc.setBounds(15,315,60,18);
        selectFrame.add(editName);
        DetailPanel.add(editBatchno);
        DetailPanel.add(editQuantity);
        DetailPanel.add(editmfgdate);
        DetailPanel.add(editMrp);
        DetailPanel.add(editexpdate);
        descPanel.add(editDesc);
        selectFrame.repaint();
        selectFrame.invalidate();
        selectFrame.validate();
        DetailPanel.repaint();
        DetailPanel.invalidate();
        DetailPanel.validate();
        
                
                
        //
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM grocerystore WHERE pid =" + pid );
                pstmt.executeUpdate();
                selectFrame.dispose();
                mainGui(getRows());
               
            }catch(Exception err){err.printStackTrace();}
            }
        });
        //edit name
        editName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update Name");
                nameFrame.setSize(600,150);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel productname=new JLabel("Product Name:");
                productname.setBounds(10,10,120,30);
            
                nameFrame.add(productname);
                JTextField nameField=new JTextField();            
                nameField.setBounds(140,10,360,30);

                nameFrame.add(nameField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,60,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(nameField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET productname ='"+nameField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        //edit batchno.
        editBatchno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update Batch No.");
                nameFrame.setSize(600,150);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel batchno=new JLabel("Batch No.:");
                batchno.setBounds(10,10,120,30);
            
                nameFrame.add(batchno);
                JTextField batchField=new JTextField();            
                batchField.setBounds(140,10,360,30);

                nameFrame.add(batchField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,60,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(batchField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET batchno ='"+batchField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        //edit quantity
        editQuantity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update Name");
                nameFrame.setSize(600,150);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel quantity=new JLabel("Quantity:");
                quantity.setBounds(10,10,120,30);
            
                nameFrame.add(quantity);
                JTextField quantityField=new JTextField();            
                quantityField.setBounds(140,10,360,30);

                nameFrame.add(quantityField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,60,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(quantityField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET quantity ='"+quantityField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        //edit mfgdate
        editmfgdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update Manufactring Date");
                nameFrame.setSize(600,150);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel mfg=new JLabel("M.R.P :");
                mfg.setBounds(10,10,120,30);
            
                nameFrame.add(mfg);
                JTextField mfgField=new JTextField();            
                mfgField.setBounds(140,10,360,30);

                nameFrame.add(mfgField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,60,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(mfgField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET mfgdate ='"+mfgField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        //edit expdate
        editexpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update Manufactring Date");
                nameFrame.setSize(600,150);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel exp=new JLabel("M.R.P :");
                exp.setBounds(10,10,120,30);
            
                nameFrame.add(exp);
                JTextField expField=new JTextField();            
                expField.setBounds(140,10,360,30);

                nameFrame.add(expField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,60,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(expField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET expdate ='"+expField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        //edit mrp
        editMrp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update M.R.P");
                nameFrame.setSize(600,150);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel mrp=new JLabel("M.R.P :");
                mrp.setBounds(10,10,120,30);
            
                nameFrame.add(mrp);
                JTextField MrpField=new JTextField();            
                MrpField.setBounds(140,10,360,30);

                nameFrame.add(MrpField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,60,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(MrpField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET mrp ='"+MrpField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        // edit description
        editDesc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectFrame.dispose();
                JFrame nameFrame=new JFrame("Update Description");
                nameFrame.setSize(600,400);
                nameFrame.setLocationRelativeTo(null);
                nameFrame.setResizable(false);
                nameFrame.setVisible(true);
                nameFrame.setLayout(null);
                JLabel cname=new JLabel("New Description:");
                cname.setBounds(10,10,120,30);
            
                nameFrame.add(cname);
                JTextArea nameField=new JTextArea();            
                nameField.setBounds(140,10,360,280);
                nameField.setLineWrap(true);
                nameField.setWrapStyleWord(true);
                nameFrame.add(nameField);

                JButton updatebtn=new JButton("Update");
                updatebtn.setBounds(240,300,90,30);
                nameFrame.add(updatebtn);
                nameFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try{
                    viewGui(pid,getRows());
                    }catch(Exception error){error.printStackTrace();}
                }
                });
                updatebtn.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         try{
                            if(!(nameField.getText().equals(""))){
                            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");
                            PreparedStatement pstmt = con.prepareStatement("UPDATE grocerystore SET description ='"+nameField.getText()+"'WHERE pid=" + pid );
                            pstmt.executeUpdate();
                            nameFrame.dispose();
                            viewGui(pid,getRows());
                            }
                         }catch(Exception er){er.printStackTrace();}
                            
                     } 
                });
            }
        });
        
        selectFrame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
           mainGui(getRows());
        }
          });
        }catch(Exception e){e.printStackTrace();}
    }
    public static void  mainGui(String[][] rowdata){
        String[][] rows=rowdata;
        JFrame frame=new JFrame("My Grocery Store.....");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        String columns[]={"ID","NAME","CATEGORY","BATCH NO.","Mfg date","Exp date","QUANTITY","M.R.P"};  
        JTable list=new JTable(rows,columns);
        JLabel infoTitle=new JLabel("CLick To View ");
        infoTitle.setBounds(885,200,120,100);
        frame.add(infoTitle);
        JButton searchBtn =new JButton("Search");
        searchBtn.setBounds(760,10,80,30);
        frame.add(searchBtn);
        JTextField searchBar=new JTextField();
        searchBar.setBounds(180,10,560,30);
        searchBar.setFont(new Font("Serif", Font.BOLD, 20));
        frame.add(searchBar);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );//to center first column of list table
        list.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
        list.getColumnModel().getColumn(0). setPreferredWidth(0);
        
        JPanel tablePanel=new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(15,50,860,600);  
        list.setRowHeight(35);
        list.setFont(new Font("Serif", Font.BOLD, 12));
        list.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setSize(845, 500);
        tablePanel.add(scrollPane);
        frame.add(tablePanel);
        frame.setResizable(false);
        frame.repaint();
        frame.invalidate();
        frame.validate();
        JButton add=new JButton("ADD");
        add.setBounds(875,100,80,40);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){              
                addRowGui(getRows());
                frame.dispose();
            }
        });
        searchBtn.addActionListener((e)->{
            try{
        if(!searchBar.getText().equals("")){
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stores","root","");           
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from grocerystore where productname='"+searchBar.getText()+"'");        
            rs.next();
            searchBar.setText("");
            String []data={Integer.toString(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getDate(6).toString(),rs.getDate(7).toString(),rs.getString(5),Integer.toString(rs.getInt(9)),rs.getString(8)};
            for(int j=0;j<rows.length;j++){
                for(int k=0;k<rows[j].length;k++){
                    rows[j][k]=null;
                }
            }
            int i=0;
            while(i<3){
                System.out.println(data[i]);
                i++;
            }
            rows[0]=data;
            frame.repaint();
            frame.invalidate();
            frame.validate();   
        }
            }catch(Exception ex){ex.getMessage();}
    });
        frame.add(add);
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting() && list.getSelectedRow() != -1) {
            String Pid=list.getValueAt(list.getSelectedRow(), 0).toString();
            try{
            frame.dispose();
            viewGui(Pid,getRows());
            System.out.println(Pid);
            }catch(Exception e){e.printStackTrace();}
            }
        }
    });
    }
    public static void main(String[] args) {
        try{
        mainGui(getRows());  
    }
    catch(Exception e){
       e.printStackTrace();
    }
    }
    
}