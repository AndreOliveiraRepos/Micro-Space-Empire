/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Estado.End;
import Estado.Fase1;
import Estado.Fase3;
import Estado.IE;
import static Modelo.Globais.MAXSISTEMAS;
import Modelo.ModeloJogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
/**
 *
 * @author red_f
 */
public class VistaMesa extends JFrame implements Observer{
    
    private Container cp;
    private Dimension d;
    private Painel fundo, tabuleiro, IOJogador, DisplaySistema, log, ContainerDeckEventos, ContainerDeckSistemas, ContainerListas, GrelhaListas,Lista1,Lista2,FimJogo,Commerce;
    
    private InfoJogo info;
    private VistaCarta cartaDestaque,CartaEventos,CartaSistemasProximos,CartaSistemasDistantes, Descarte;
    private JButton Passar,WealthForMetal,MetalForWealth;
    private JTextField Estado;
    private JTextArea MensagemSistema,Fim;
    private ModeloJogo modelo;
    private JMenuBar menu;
    //contrutor default
    public VistaMesa(ModeloJogo m){
        
        this.modelo = m;
        this.modelo.addObserver(this);
        d = new Dimension(1024,768);
        cp = getContentPane();
        setMinimumSize(new Dimension(800,600));
        setPreferredSize(d);
        
        
        setSize(this.getPreferredSize());
        cp.setBackground(Color.BLACK);
        
        setVisible(true);
        criarObjGraf();
        disporVista();
        registarListeners();
        this.modelo.Iniciar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }
    
    //contrutor com medidas
     public VistaMesa(int w,int h){
        cp = getContentPane();
        //criarObjGraf();
        //disporVista();
        d = new Dimension(w,h);
        setPreferredSize(d);
        setMaximumSize(d);
        //registarListeners();
        
        setSize(this.getPreferredSize());
        cp.setBackground(Color.BLACK);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }
    
    
    protected void criarObjGraf(){
        Double d;
        menu = new JMenuBar();
        JMenu file = new JMenu("File");
        menu.add(file);
        
        
        fundo = new Painel(new BorderLayout(), false, this.getHeight(), this.getWidth(), this.modelo);
        fundo.setImage("img/fundo.jpg");
        d = this.getHeight()*0.60;
        
        //container tabuleiro
        tabuleiro = new Painel(new BorderLayout(), false, this.getWidth(),this.getHeight(), this.modelo);
        //container fim do jogo
        FimJogo = new Painel(new BorderLayout(), false, this.getWidth(),this.getHeight(), this.modelo);
        Fim = new JTextArea();
        Fim.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Fim.setForeground(Color.white);
        //container iniciais
        DisplaySistema = new Painel(new BorderLayout(), false,this.getWidth(),d.intValue(), this.modelo); 
        IOJogador  = new Painel(new BorderLayout(), false,this.getWidth(),this.getHeight() - d.intValue(), this.modelo);//verlayouts
        
        
        
        //displaysIO
        d = this.getWidth() * 0.35;
        log = new Painel(new BorderLayout(),true, this.modelo);
        log.setBackground(Color.GRAY);
        Passar = new JButton("Passar");
        Estado = new JTextField();
        MensagemSistema = new JTextArea();
        MensagemSistema.setFont(new Font("Times New Roman", Font.BOLD, 15));
        MensagemSistema.setForeground(Color.white);
        info = new InfoJogo(this.getWidth(),this.getHeight(),this.modelo);
        
        ContainerDeckEventos =  new VistaCarta(new BorderLayout(),false,d.intValue(),this.getHeight(), this.modelo);
        ContainerDeckSistemas = new VistaCarta(new BorderLayout(),false,d.intValue(),this.getHeight(), this.modelo);
        CartaEventos = new VistaCarta(new BorderLayout(),true,248,348, this.modelo);
        CartaEventos.setImage("img/back/Evento.jpg");
        Descarte = new VistaCarta(new BorderLayout(),true,248,348, this.modelo);
        Descarte.setBackground(Color.BLACK);
        
        CartaSistemasProximos = new VistaCarta(new BorderLayout(),true,248,348, this.modelo);//passar isto para globals
        CartaSistemasProximos.setImage("img/back/sistema.jpg");
        CartaSistemasDistantes = new VistaCarta(new BorderLayout(),true,248,348, this.modelo);
        CartaSistemasDistantes.setImage("img/back/sistema.jpg");
        
        //displaysSistemas
        
        ContainerListas = new Painel(new BorderLayout(), false,this.getWidth(),d.intValue(), this.modelo);
        cartaDestaque = new VistaCarta(new BorderLayout(),false,248,348, this.modelo);
        cartaDestaque.setBackground(Color.WHITE);
        
        Commerce = new Painel(new BorderLayout(), false,this.getWidth(),d.intValue(), this.modelo);
        Commerce.setImage("img/commerce.png");
        WealthForMetal = new JButton("Wealth for Metal");
        MetalForWealth = new JButton("Metal for Wealth");
       
        GrelhaListas = new Painel(new BorderLayout(), false,this.getWidth(),d.intValue(), this.modelo); 
        
        Lista1 = new Painel(new BorderLayout(), false,this.getWidth(),d.intValue(), this.modelo); 
        Lista2 = new Painel(new BorderLayout(), false,this.getWidth(),d.intValue(), this.modelo); 
        
        
    
    }
    protected void disporVista(){
        
        Double w,h = this.getWidth() * 0.33;
        Border b = BorderFactory.createLineBorder(Color.WHITE);  
        Box caixaH = Box.createHorizontalBox();
        Box caixaV1 = Box.createVerticalBox();
        Box caixaV2 = Box.createVerticalBox();
        
        Box caixaHS = Box.createHorizontalBox();
        Box caixaVS1 = Box.createVerticalBox();
        Box caixaVS2 = Box.createVerticalBox();
        
        MensagemSistema.setOpaque(false);
        MensagemSistema.setBorder(BorderFactory.createEmptyBorder());
        MensagemSistema.setEditable(false);
        MensagemSistema.setHighlighter(null);
        
        
        Fim.setOpaque(false);
        Fim.setBorder(BorderFactory.createEmptyBorder());
        Fim.setEditable(false);
        Fim.setHighlighter(null);
        
        
        
        ContainerDeckEventos.setLayout(new BoxLayout(ContainerDeckEventos,BoxLayout.Y_AXIS));
        ContainerDeckSistemas.setLayout(new BoxLayout(ContainerDeckSistemas,BoxLayout.Y_AXIS));
        
        Descarte.setBorder(b);
        CartaEventos.setBorder(b);
        caixaV1.add(Box.createVerticalGlue());
        caixaV1.add(Box.createVerticalStrut(20));
        caixaV1.add(CartaEventos);
        caixaV1.add(Box.createVerticalStrut(20));
        caixaH.add(Box.createHorizontalStrut(20));
        caixaH.add(caixaV1);
        
        caixaV2.add(Box.createVerticalGlue());
        caixaV2.add(Box.createVerticalStrut(20));
        caixaV2.add(Descarte);
        caixaV2.add(Box.createVerticalStrut(20));
        caixaH.add(Box.createHorizontalStrut(20));
        caixaH.add(caixaV2);
        caixaH.add(Box.createHorizontalStrut(20));
        ContainerDeckEventos.add(caixaH);

        Commerce.setVisible(false);
        Commerce.setLayout(new BoxLayout(Commerce,BoxLayout.Y_AXIS));
        //tamanhos ContainerListas.getWidth()*0.20)
        Box caixaVC = Box.createVerticalBox();
        Box caixaHC = Box.createHorizontalBox();
        caixaVC.add(Box.createVerticalStrut(50));
        caixaVC.add(WealthForMetal);
        caixaVC.add(Box.createVerticalStrut(50));
        caixaVC.add(MetalForWealth);
        caixaVC.add(Box.createVerticalStrut(50));
         
        caixaHC.add(Box.createHorizontalStrut(50));
        caixaHC.add(caixaVC);
        caixaHC.add(Box.createHorizontalStrut(50));
        Commerce.add(caixaHC);
        //Commerce.add(,BorderLayout.NORTH);
        //Commerce.add(MetalForWealth,BorderLayout.SOUTH);
        
        CartaSistemasDistantes.setBorder(b);
        CartaSistemasProximos.setBorder(b);
        w = this.getWidth()*0.3;
        CartaSistemasProximos.setPreferredSize(new Dimension(w.intValue(), 348));
        CartaSistemasDistantes.setPreferredSize(new Dimension(w.intValue(), 348));
        caixaVS1.add(Box.createVerticalGlue());
        caixaVS1.add(Box.createVerticalStrut(20));
        caixaVS1.add(CartaSistemasProximos);
        caixaVS1.add(Box.createVerticalStrut(20));
        caixaHS.add(Box.createHorizontalStrut(20));
        caixaHS.add(caixaVS1);
        
        caixaVS2.add(Box.createVerticalGlue());
        caixaVS2.add(Box.createVerticalStrut(20));
        caixaVS2.add(CartaSistemasDistantes);
        caixaVS2.add(Box.createVerticalStrut(20));
        caixaHS.add(Box.createHorizontalStrut(20));
        caixaHS.add(caixaVS2);
        caixaHS.add(Box.createHorizontalStrut(20));
        
        ContainerDeckSistemas.add(caixaHS);
        CartaSistemasProximos.setVisible(true);
        
        
        
        log.setBorder(b);
        log.setLayout(new BorderLayout());
        log.add(MensagemSistema, BorderLayout.CENTER);
        log.add(Passar,BorderLayout.SOUTH);
        DisplaySistema.setBorder(b);
        IOJogador.setBorder(b);
        
        ContainerListas.add(cartaDestaque,BorderLayout.WEST);
        w = this.getWidth()*0.3;
        cartaDestaque.setPreferredSize(new Dimension(w.intValue(),348));
        
        Lista1.setLayout(new GridLayout(1,11));
        Lista2.setLayout(new GridLayout(1,11));
        preencheListas();
        
        GrelhaListas.setLayout(new GridLayout(2,1));
        
        Painel Lista1Container = new Painel(new BorderLayout(),false,10,10,modelo);
        Painel Lista2Container = new Painel(new BorderLayout(),false,10,10,modelo);
        Lista1Container.setLayout(new BoxLayout(Lista1Container, BoxLayout.Y_AXIS));
        Lista2Container.setLayout(new BoxLayout(Lista2Container, BoxLayout.Y_AXIS));
        
        h = this.getHeight() * 0.05;
        
        
        Box vertical = Box.createVerticalBox();
        Box vertical2 = Box.createVerticalBox();
        
        vertical.add(Box.createVerticalStrut(h.intValue()));
        vertical.add(Lista1);
        vertical.add(Box.createVerticalStrut(h.intValue()));
        Lista1Container.add(vertical);
        
        vertical2.add(Box.createVerticalStrut(h.intValue()));
        vertical2.add(Lista2);
        vertical2.add(Box.createVerticalStrut(h.intValue()));
        Lista2Container.add(vertical2);
        
        
        
        
        GrelhaListas.add(Lista1Container);
        GrelhaListas.add(Lista2Container);
        
        ContainerListas.add(GrelhaListas,BorderLayout.CENTER);
        
        info.setBorder(b);
        DisplaySistema.add(ContainerListas,BorderLayout.CENTER);
        DisplaySistema.add(info,BorderLayout.WEST);
        
        cartaDestaque.setVisible(false);
        
        
        
        
        IOJogador.add(log,BorderLayout.CENTER);
        IOJogador.add(ContainerDeckEventos,BorderLayout.WEST);
        IOJogador.add(ContainerDeckSistemas,BorderLayout.EAST);
        
        
        tabuleiro.add(DisplaySistema,BorderLayout.CENTER);
        tabuleiro.add(IOJogador,BorderLayout.SOUTH);
        
        fundo.add(tabuleiro, BorderLayout.CENTER);
        
        cp.setLayout(new BorderLayout());
        cp.add(menu,BorderLayout.NORTH);
        cp.add(fundo);
        
        
        //FimJogo.add(Fim,BorderLayout.CENTER);
        
    }
    
    protected void registarListeners(){
        
        cartaDestaque.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*if(modelo.getEstado() instanceof Fase3)
                {
                    
                    cartaDestaque.setVisible(false);
                    preencheListas();
                    repaint();
                }*/
                cartaDestaque.setVisible(false);
                if(modelo.getEstado() instanceof Fase3){
                    GrelhaListas.setVisible(true);
                    preencheListas();
                    Lista1.setVisible(true);
                    Lista2.setVisible(true);
                }
                else if(modelo.getEstado() instanceof IE)
                {
                    
                    Commerce.setVisible(true);
                    ContainerListas.add(Commerce,BorderLayout.WEST);
                    Lista1.setVisible(false);
                    Lista2.setVisible(false);
                    
                }
                else{
                    GrelhaListas.setVisible(true);
                    preencheListas();
                }
                revalidate();
                repaint();
                
                 
            }
        });
        CartaEventos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                //modelo.setCartaDestacada();
                    if(modelo.getEstado() instanceof Fase3 && !cartaDestaque.isVisible() && !Commerce.isVisible()){
                        GrelhaListas.setVisible(false);
                    
                        modelo.CompraEvento();
                        cartaDestaque.setImage(modelo.getCartaDestacada());

                        cartaDestaque.setVisible(true);

                        MensagemSistema.setText(modelo.getRelatorioCombate() );
                        Descarte.setImage(modelo.getCartaDestacada());
                        if (modelo.getEventos().size()== 0){
                            CartaEventos.setVisible(false);
                        }
                        
                    }
                    else if(cartaDestaque.isVisible()){
                        modelo.setMensagemSistema("[SISTEMA]Clique na carta\nem destaque!");
                    }
                    else if(Commerce.isVisible()){
                        modelo.setMensagemSistema("[SISTEMA]Escolha uma operação ou passe!");
                    }
                    else{
                        modelo.setMensagemSistema("[SISTEMA ]Só pode comprar um\nEvento na sua devida fase!");
                    }
                    repaint();
                 
            }
        });
        CartaSistemasProximos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
               
                //System.out.print
                
                if(modelo.getEstado() instanceof Fase1 && !cartaDestaque.isVisible() && !Commerce.isVisible() )
                {
                    GrelhaListas.setVisible(false);
                    cartaDestaque.setVisible(true);
                    modelo.CompraProximo();
                    cartaDestaque.setImage(modelo.getCartaDestacada());

                    
                    
                    MensagemSistema.setText(modelo.getRelatorioCombate() );
                    if (modelo.getTamanhoProximos()== 0){
                        CartaSistemasProximos.setVisible(false);
                    }
                    
                   
                }
                else if(cartaDestaque.isVisible()){
                    modelo.setMensagemSistema("[SISTEMA]Clique na carta\nem destaque!");
                }
                else if(Commerce.isVisible()){
                    modelo.setMensagemSistema("[SISTEMA]Escolha uma operação ou passe!");
                }
                else{
                        modelo.setMensagemSistema("[SISTEMA]Só pode comprar um\nSistema Proximo na sua devida fase!");
                }
                
                
                revalidate();
                repaint();
                    
            }
        });
        CartaSistemasDistantes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
               
                //modelo.setCartaDestacada();
                
                if(modelo.getEstado() instanceof Fase1 && !cartaDestaque.isVisible() && !Commerce.isVisible() && modelo.getTechs(0, 1).getLearn() )
                {
                    
                    GrelhaListas.setVisible(false);
                    
                    modelo.CompraDistante();
                    
                    if(modelo.getCartaDestacada() != null)
                    {   
                        
                        cartaDestaque.setImage(modelo.getCartaDestacada());
                        cartaDestaque.setVisible(true);
                       
                        MensagemSistema.setText(modelo.getRelatorioCombate() );
                    
                    }
                    //System.out.println("Tamanho proximo:"+modelo.getTamanhoDistantes());
                    if (modelo.getTamanhoDistantes()== 0){
                        CartaSistemasDistantes.setVisible(false);
                    }
                    
                    
                    
                }
                else if(!(modelo.getEstado() instanceof Fase1)){
                    modelo.setMensagemSistema("[Sistema]Só pode comprar um\nSistema Proximo na sua devida fase!");
                       
                }
                else if(!modelo.getTechs(0, 1).getLearn())
                {
                    modelo.setMensagemSistema("[Sistema]Não tem Forward Bases!");
                }
                else if(Commerce.isVisible()){
                        modelo.setMensagemSistema("[SISTEMA]Escolha uma operação ou passe!");
                     }
                else if(cartaDestaque.isVisible()){
                    modelo.setMensagemSistema("[SISTEMA]Clique na carta\nem destaque!");
                }
                
                repaint();
            }
        });
        
        Passar.addActionListener(new PassaListener());
        MetalForWealth.addActionListener(new MforWListener());
        WealthForMetal.addActionListener(new WforMListener());
    }
    void preencheListas(){
        Lista1.removeAll();
        Lista2.removeAll();
        //final int i;
        for (int i = 0; i < MAXSISTEMAS; i++) {
            if(i >= modelo.getTamanhoDesalinhados() || modelo.getTamanhoDesalinhados() == 0){
                
                Lista1.add(new VistaCarta(new BorderLayout(),false,0,0,modelo));
            }
            else{
                VistaCarta c = new VistaCarta(new BorderLayout(),true,100,100,modelo,modelo.getImagem(modelo.getDesalinhados().get(i).getNome()));
                final int x = i;
                c.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseClicked(MouseEvent e){
                            //System.out.println("click");
                            if (modelo.getEstado() instanceof Fase1) {
                                modelo.Conquer(x);
                                modelo.setMensagemSistema(modelo.getRelatorioCombate());
                            
                            }
                            else{
                                modelo.setMensagemSistema("[Sistema] Só pode conquistar\nno fase devida!");
                            }
                    }
                });
                Lista1.add(c);
                
                
            }
        }
        
        for (int i = 0; i < MAXSISTEMAS; i++) {
            if(i >= modelo.getTamanhoConquistados() || modelo.getTamanhoConquistados() == 0){
                Lista2.add(new VistaCarta(new BorderLayout(),false,0,0,modelo));
            }
            else{
                
                    Lista2.add(new VistaCarta(new BorderLayout(),true,100,100,modelo,modelo.getImagem(modelo.getConquistados().get(i).getNome())));
                
                
            }
        }
        
    }
    
    
    public void update(Observable t, Object o) {
        
        if (modelo.getEstado() instanceof End) {
            Fim.setText(modelo.getMensagemSistema());
            
            FimJogo.add(Fim,BorderLayout.CENTER);
            tabuleiro.removeAll();
            
            
            
            
            
            tabuleiro.add(FimJogo);
            
            
        }
        else if(modelo.getEstado() instanceof IE )
        {
            MensagemSistema.setText(modelo.getMensagemSistema());
            if (modelo.getTotMetal() < 2 ) {
               MetalForWealth.setVisible(false);
            }
             else
                MetalForWealth.setVisible(true);
            if(modelo.getTotWealth() < 2)
                WealthForMetal.setVisible(false);
            else
                WealthForMetal.setVisible(true);
            if (!cartaDestaque.isVisible()) {
                Commerce.setVisible(true);
                ContainerListas.add(Commerce,BorderLayout.WEST);
            }
            MensagemSistema.setText(modelo.getMensagemSistema());
            Lista1.setVisible(false);
            Lista2.setVisible(false);
        }
        else if(modelo.getEstado() instanceof Fase1){
            MensagemSistema.setText(modelo.getMensagemSistema());
            preencheListas();
            
            Lista1.setVisible(true);
            Lista2.setVisible(true);
            //Commerce.setVisible(false);
            //cartaDestaque.setVisible(false);
           
        
            
            
        }
        else if(modelo.getEstado() instanceof Fase3){
            //preencheListas();
           //MensagemSistema.setText(modelo.getMensagemSistema());
            //MensagemSistema.setText(modelo.getMensagemSistema());
            Commerce.setVisible(false);
            //Commerce.setVisible(false);
            //cartaDestaque.setVisible(false);
            ContainerListas.remove(Commerce);
            MensagemSistema.setText(modelo.getMensagemSistema());
            /*ContainerListas.add(cartaDestaque,BorderLayout.WEST);*/
            //GrelhaListas.setVisible(true);
            
            //Lista1.setVisible(true);
            //Lista2.setVisible(true);
            
            
            
            
            
            
        }
        repaint();
        revalidate();
    }
    
    class PassaListener implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.getEstado() instanceof Fase3) {
                modelo.setMensagemSistema("[SISTEMA] Compre um evento\npara passar de turno");
                repaint();
                revalidate();
            }
            else{
                modelo.PassarFase();
                repaint();
                revalidate();
            }
            
        }
    
    }
    
    class MforWListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            modelo.Commerce(1);
            
        }

    }
    class WforMListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.Commerce(2);
            
        }

    }
}
