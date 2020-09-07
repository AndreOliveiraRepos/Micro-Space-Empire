/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import State.Phase1;
import State.Phase3;
import State.IE;
import Models.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author André Oliveira
 */
public class GameInformation extends JPanel implements Observer {
    Box vertical,horizontal;
    private JTextField ano, turno, estado, nMetal, nWealth, nMilitar;
    private JLabel l;
    private JPanel cont,grelha,gridMetal, gridWealth, gridMilitar, ResearchButton;
    private Game modelo;
    private ImageIcon metal,wealth, militar;
    List<JLabel> metalList, wealthList, militarList ;
    public GameInformation(int w, int h, Game m){
        //recebe o modelo para ir buscar os dados e imprimir
        //montar labels
        //cont pode conter a tech
        Border b = BorderFactory.createLineBorder(Color.WHITE);  
        Double width, height;
        modelo = m;
        modelo.addObserver(this);
        width = w*0.35;
        Dimension d = new Dimension(width.intValue(),h);
        metalList = new ArrayList<JLabel>();
        wealthList = new ArrayList<JLabel>();
        militarList = new ArrayList<JLabel>();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(d));
        ;
        this.setOpaque(false);
        grelha = new JPanel();
        
        Box vertical = Box.createVerticalBox();
        Box horizontal = Box.createHorizontalBox();
        
        vertical.add(Box.createVerticalStrut(50));
        vertical.add(grelha);
        vertical.add(Box.createVerticalStrut(50));
        horizontal.add(Box.createHorizontalStrut(50));
        horizontal.add(vertical);
        horizontal.add(Box.createHorizontalStrut(50));
        
        grelha.setOpaque(false);
        grelha.setLayout(new GridLayout(11,1));
        
        ResearchButton = new JPanel(new BorderLayout());
        l = new JLabel("Research");
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        ResearchButton.add(l );
        ResearchButton.setBackground(Color.white);
        
        
        ano = new JTextField("ANO: ");
        ano.setOpaque(false);
        ano.setBorder(BorderFactory.createEmptyBorder());
        ano.setEditable(false);
        ano.setHighlighter(null);
        
        turno = new JTextField("TURNO: ");
        turno.setOpaque(false);
        turno.setBorder(BorderFactory.createEmptyBorder());
        turno.setEditable(false);
        turno.setHighlighter(null);
        
        estado = new JTextField("Estado: ");
        estado.setOpaque(false);
        estado.setBorder(BorderFactory.createEmptyBorder());
        estado.setEditable(false);
        estado.setHighlighter(null);
        
        nMetal = new JTextField("Metal");
        nMetal.setOpaque(false);
        nMetal.setBorder(BorderFactory.createEmptyBorder());
        nMetal.setEditable(false);
        nMetal.setHighlighter(null);
        
        nWealth = new JTextField("Wealth");
        nWealth.setOpaque(false);
        nWealth.setBorder(BorderFactory.createEmptyBorder());
        nWealth.setEditable(false);
        nWealth.setHighlighter(null);
        
        nMilitar = new JTextField("Militar");
        nMilitar.setOpaque(false);
        nMilitar.setBorder(BorderFactory.createEmptyBorder());
        nMilitar.setEditable(false);
        nMilitar.setHighlighter(null);
        
        
        
        gridMetal = new JPanel();
        gridMetal.setLayout(new GridLayout(1,5));
        //gridMetal.setBackground(Color.red);
        gridMetal.setOpaque(false);
        
        gridMetal.setPreferredSize(new Dimension(grelha.getWidth(),grelha.getHeight()));
        try {
            metal = new ImageIcon(ImageIO.read(new File("img/icons/metal.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                    
        } catch (IOException ex) {
            System.out.println("Sem imagem");
        }
        
        
        gridWealth = new JPanel();
        gridWealth.setLayout(new GridLayout(1,5));
        //gridWealth.setBackground(Color.blue);
        gridWealth.setOpaque(false);
        //gridWealth.setBorder(b);
        gridWealth.setPreferredSize(new Dimension(grelha.getWidth(),grelha.getHeight()));
        
        try {
            wealth = new ImageIcon(ImageIO.read(new File("img/icons/wealth.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                    
        } catch (IOException ex) {
            System.out.println("Sem imagem");
        }
        
        gridMilitar = new JPanel();
        gridMilitar.setLayout(new GridLayout(1,5));
        //gridWealth.setBackground(Color.blue);
        gridMilitar.setOpaque(false);
        //gridWealth.setBorder(b);
        gridMilitar.setPreferredSize(new Dimension(grelha.getWidth(),grelha.getHeight()));
        
        try {
            militar = new ImageIcon(ImageIO.read(new File("img/icons/militar.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                    
        } catch (IOException ex) {
            System.out.println("Sem imagem");
        }
        
        for (int i = 0; i < 5 ; i++) {
            metalList.add(new JLabel(metal));
            //metalList.add(new JLabel());
            
            metalList.get(i).setBorder(b);
            gridMetal.add(metalList.get(i));
            //gridMetal.;
        }
        
        for (int i = 0; i < 5 ; i++) {
            militarList.add(new JLabel(militar));
            //metalList.add(new JLabel());
            
            militarList.get(i).setBorder(b);
            gridMilitar.add(militarList.get(i));
            //gridMetal.;
        }
        
        for (int i = 0; i < 5 ; i++) {
            wealthList.add(new JLabel(wealth));
            wealthList.get(i).setBorder(b);
            gridWealth.add(wealthList.get(i));
        }
        
        ano.setForeground(Color.WHITE);
        turno.setForeground(Color.WHITE);
        estado.setForeground(Color.WHITE);
        nMetal.setForeground(Color.WHITE);
        nWealth.setForeground(Color.WHITE);
        nMilitar.setForeground(Color.WHITE);
        
        
        grelha.add(ano);
        grelha.add(turno);
        //grelha.add(estado); DEBUG
        grelha.add(nMetal);
        grelha.add(gridMetal);
        grelha.add(nWealth);
        grelha.add(gridWealth);
        grelha.add(nMilitar);
        grelha.add(gridMilitar);
        JPanel filler = new JPanel();
        filler.setOpaque(false);
        grelha.add(filler);
        grelha.add(ResearchButton);
        this.add(horizontal,BorderLayout.CENTER);
        
        //monta a lista da tech
        
        
        
        
        
        
        registarListeners();
       
        
        
    }
    public void setAno(){}
    public void setTurno(){}
    
    
    public void update(java.util.Observable t, Object o) {
        
        for (int i = 0; i < 5; i++) {
                
                     metalList.get(i).setOpaque(false);
                     
                     wealthList.get(i).setOpaque(false);
                     
                     militarList.get(i).setOpaque(false);  
                     

        }
        
        ano.setText("ANO:" + String.valueOf(this.modelo.getYear()));
        turno.setText("Turno:" + String.valueOf(this.modelo.getTurn()));
        estado.setText("State " + this.modelo.getStateName());
        /*System.out.println("metal "+ modelo.getTotMetal());
        System.out.println("wealth "+ modelo.getTotWealth());
        System.out.println("Militar "+ modelo.getTotMilitar());*/
        if(modelo.getTotMetal()> 0){
            for (int i = 0; i < modelo.getTotMetal(); i++) {
                if (!metalList.get(i).isOpaque()) {
                     metalList.get(i).setOpaque(true);
                     metalList.get(i).setBackground(Color.BLUE);
                }          

            }
        }
        if(modelo.getTotWealth()> 0){
            for (int i = 0; i < modelo.getTotWealth(); i++) {
                if (!wealthList.get(i).isOpaque()) {
                     wealthList.get(i).setOpaque(true);
                     wealthList.get(i).setBackground(Color.yellow);
                }          

            }
        }
        if(modelo.getTotMilitar()> 0){
            for (int i = 0; i < modelo.getTotMilitar(); i++) {
                if (!militarList.get(i).isOpaque()) {
                     militarList.get(i).setOpaque(true);
                     militarList.get(i).setBackground(Color.LIGHT_GRAY);
                }          

            }
        }
        if (modelo.getState() instanceof Phase1 || modelo.getState() instanceof IE ) {
            ResearchButton.setVisible(false);
        }
        else{
            ResearchButton.setVisible(true);
        }
        repaint();
        
    }
    
    protected void MostraTechTree(){
        int i, j;
        grelha.removeAll();
        grelha.setLayout(new GridLayout(4,2));
        /*ArrayList<ArrayList<JLabel>> listaTechs = new ArrayList<ArrayList<JLabel>>();
        
        for (int i = 0; i < 4; i++) {
            ArrayList<JLabel> linha = new ArrayList<JLabel>();
            listaTechs.add(linha);
            for (int j = 0; j < 2; j++) {
                linha.add(new JLabel("teste"+i+j));
                
            }
            
            
        }*/
        JLabel l;
        Border b = BorderFactory.createLineBorder(Color.black);  
        for (i = 0; i < 4; i++) {
           
            
           
            for (j = 0; j < 2; j++) {
                 l = new JLabel(modelo.getTechs(i, j).getNome());
                 if(modelo.getTechs(i, j).getLearn())
                    l.setBackground(Color.green);
                 else
                     l.setBackground(Color.white);
                 l.setOpaque(true);
                 l.setHorizontalAlignment(SwingConstants.CENTER);
                 l.setVerticalAlignment(SwingConstants.CENTER);
                 l.setBorder(b);
                 l.setPreferredSize(new Dimension(grelha.getHeight()/4,grelha.getHeight()/4));
                 final int x = i, y = j; 
                 l.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseClicked(MouseEvent e){
                            modelo.Research(x, y);
                            ReconstroiInfo();    
                    }
                });
                grelha.add(l);
            }
        }
        //
        
        repaint();
        revalidate();
    }
    
    
    protected void ReconstroiInfo(){
        grelha.removeAll();
        grelha.setLayout(new GridLayout(11,1));
        grelha.add(ano);
        grelha.add(turno);
        grelha.add(estado);
        grelha.add(nMetal);
        grelha.add(gridMetal);
        grelha.add(nWealth);
        grelha.add(gridWealth);
        grelha.add(nMilitar);
        grelha.add(gridMilitar);
        JPanel filler = new JPanel();
        filler.setOpaque(false);
        grelha.add(filler);
        grelha.add(ResearchButton);
    }
    protected void registarListeners(){
        
        
        
        gridMilitar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (modelo.getState() instanceof Phase3) {
                    modelo.buildRecruit();
                }
                else
                    modelo.setSystemMessage("[SISTEMA]Só pode recrutar\nno fase correcta");
                /*repaint();
                revalidate();*/
            }
        });
        
        ResearchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                
                MostraTechTree();
            }
        });
    }
    
    
    
    
    
  
}
