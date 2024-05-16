/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import grafos.Dijkstra;
import grafos.Locacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author saul
 */
public class RutasDijkstraFrame extends javax.swing.JFrame {

    //private Graphics2D backBuffer;
    private ImageIcon imagenMapaITSON;
    
    private Dijkstra calculadorRutas;
    private List<Locacion> listaLocaciones;
    
    private Locacion origenSeleccionado;
    private Locacion destinoSeleccionado;
    private List<Integer> trazaRutaActual;
    
    private boolean dibujarCamino;
    
    private int[][] grafo;
    
    /**
     * Creates new form RutasDijkstraFrame
     */
    public RutasDijkstraFrame() {
 
        // Cambia la ruta a la ubicación de tu imagen
        this.imagenMapaITSON = new ImageIcon(getClass().getResource("mapaNainari.jpg"));
        
        
        initComponents();
        
        this.inicializarGrafico();
        
        
        
        
        this.locacionesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (locacionesList.getSelectedValue() != null) {
                    botonAsignarDistancia.setEnabled(true);
                    botonCalcularDistancia.setEnabled(true);
                } else {
                    botonAsignarDistancia.setEnabled(false);
                    botonCalcularDistancia.setEnabled(false);
                }
            }
        
        });
        
        this.mapaPanel.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                
                DefaultListModel<Locacion> elementos = getDatosListaGrafica();
                
                Locacion locacion = new Locacion(me.getX() - 10, me.getY() - 10);
                locacion.setNombre("Punto " + listaLocaciones.size());
                
                System.out.println(locacion.getX() + " " + locacion.getY());
                
                listaLocaciones.add(locacion);
                
                elementos.addElement(locacion);
                
                locacionesList.setModel(elementos);
                
                mapaPanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {
            
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            
            }

            @Override
            public void mouseExited(MouseEvent me) {
            
            }
        });
    }

    public DefaultListModel<Locacion> getDatosListaGrafica() {
        return (DefaultListModel<Locacion>) this.locacionesList.getModel();
    }
    
    public void inicializarGrafico() {
        
        Locacion lv1800 = new Locacion(347, 282);
        lv1800.setNombre("LV-1800");
        
        Locacion labMecatronica = new Locacion(343, 239);
        labMecatronica.setNombre("Laboratorios de ingeniería electromecánica y mecatrónica");
        
        Locacion lv1200 = new Locacion(337, 311);
        lv1200.setNombre("LV-1200");
        
        Locacion lv1100elec = new Locacion(334, 338);
        lv1100elec.setNombre("LV-1100");
        
        Locacion edfTutorias = new Locacion(342, 386);
        edfTutorias.setNombre("Tutorias y Educacion Virtual");
        
        Locacion polideportivo = new Locacion(276, 285);
        polideportivo.setNombre("Polideportivo");

        Locacion cisco = new Locacion(387, 426);
        cisco.setNombre("Cisco");

        Locacion futbolRapido = new Locacion(392, 226);
        futbolRapido.setNombre("Futbol rapido");

        Locacion centroIdiomas = new Locacion(393, 484);
        centroIdiomas.setNombre("Centro de idiomas");

        Locacion biblioteca = new Locacion(515, 410);
        biblioteca.setNombre("Biblioteca");

        Locacion departamentosItson = new Locacion(603, 359);
        departamentosItson.setNombre("Departamentos Itson");

        Locacion registroEscolar = new Locacion(431, 418);
        registroEscolar.setNombre("Registro Escolar");

        Locacion arenaItson = new Locacion(86, 317);
        arenaItson.setNombre("arena ITSON");

        Locacion canchasBasquetbol = new Locacion(266, 505);
        canchasBasquetbol.setNombre("Canchas de basquetbol");

        Locacion cafeteria = new Locacion(548, 460);
        cafeteria.setNombre("Cafeteria");

        Locacion necropcias = new Locacion(695, 537);
        necropcias.setNombre("Necropcias");
        
        this.listaLocaciones = new ArrayList<>();
        
        this.listaLocaciones.add(lv1800);
        this.listaLocaciones.add(labMecatronica);
        this.listaLocaciones.add(lv1200);
        this.listaLocaciones.add(lv1100elec);
        this.listaLocaciones.add(edfTutorias);
        this.listaLocaciones.add(polideportivo);
        this.listaLocaciones.add(cisco);
        this.listaLocaciones.add(futbolRapido);
        this.listaLocaciones.add(centroIdiomas);
        this.listaLocaciones.add(biblioteca);
        this.listaLocaciones.add(departamentosItson);
        this.listaLocaciones.add(registroEscolar);
        this.listaLocaciones.add(arenaItson);
        this.listaLocaciones.add(canchasBasquetbol);
        this.listaLocaciones.add(cafeteria);
        this.listaLocaciones.add(necropcias);
        
        
        /*
        this.grafo = {
          lv1800  {0, 40, 73, 104, 150, 100, 200, 80, 0, 0, 0, 0, 0, 0, 0, 0},
           labMecatronica {40, 0, 55, 80, 138, 188, 0, 60, 0, 0, 0, 0, 0, 0, 0, 0},
            lv1200 {50, 90, 0, 55, 100, 0, 0, 0, 0, 0, 0, 0, 200, 0, 0, 0},
           lv1100elec{90, 150, 55, 0, 40, 0, 0, 0, 0, 0, 0, 0, 200, 0, 0, 0},
            edfTutorias{138, 200, 98, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            polideportivo{80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 120, 0, 0, 0},
            cisco{0, 0, 0, 0, 0, 0, 0, 250, 65, 150, 0, 50, 0, 0, 0, 0},
            futbolRapido{0, 62, 0, 0, 0, 0, 241, 0, 310, 0, 0, 0, 0, 0, 0, 0},
            centroIdiomas{0, 0, 0, 0, 0, 0, 60, 313, 0, 0, 0, 0, 0, 0, 0, 0},
           biblioteca {0, 0, 0, 0, 0, 0, 147, 0, 0, 0, 0, 102, 0, 0, 48, 0},
            departamentosItson{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 162, 0, 0, 0, 0, 0},
            registroEscolar{0, 0, 0, 0, 0, 0, 47, 0, 0, 100, 0, 0, 0, 0, 0, 0},
            arenaItson{200, 0, 202, 208, 0, 135, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
           canchasBasquetbol {0, 0, 0, 0, 0, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0,433},
           cafeteria{0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, 0, 0, 0},
            necropcias{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 162, 0, 0,433, 0, 0},
        
            
        };
        */
        
        int auxGrafo[][] = {
            /* 0 */{0, 40, 73, 104, 150, 100, 200, 80, 0, 0, 0, 0, 0, 0, 0, 0},
            /* 1 */{40, 0, 55, 80,  138, 188, 0,   60, 0, 0, 0, 0, 0, 0, 0, 0},
            /* 2 */{50, 90, 0, 55, 100, 0, 0, 0, 0, 0, 0, 0, 200, 0, 0, 0},
            /* 3 */{90, 150, 55, 0, 40, 0, 0, 0, 0, 0, 0, 0, 200, 0, 0, 0},
            /* 4 */{138, 200, 98, 50, 0, 0, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            /* 5 */{80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 120, 0, 0, 0},
            /* 6 */{0, 0, 0, 0, 55, 0, 0, 250, 65, 150, 0, 50, 0, 0, 0, 0},
            /* 7 */{0, 62, 0, 0, 0, 0, 241, 0, 310, 0, 0, 0, 0, 0, 0, 0},
            /* 8 */{0, 0, 0, 0, 0, 0, 60, 313, 0, 0, 0, 70, 0, 85, 132, 0},
            /* 9 */{0, 0, 0, 0, 0, 0, 147, 0, 0, 0, 110, 102, 0, 0, 48, 0},
            /*10 */{0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 162, 0, 0, 0, 0, 0},
            /*11 */{0, 0, 0, 0, 0, 0, 47, 0, 70, 100, 0, 0, 0, 0, 0, 0},
            /*12 */{200, 0, 202, 208, 0, 135, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            /*13 */{0, 0, 0, 0, 0, 256, 0, 0, 85, 0, 0, 0, 0, 0, 0, 433},
            /*14 */{0, 0, 0, 0, 0, 0, 0, 0, 132, 48, 0, 0, 0, 0, 0, 180},
            /*15 */{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 162, 0, 0, 433, 180, 0}
        };
        
        // TODO: Crear una ruta al edificio 1300 para que sea mas util el programa...
        
        this.grafo = auxGrafo;

        
        this.actualizarListaGrafica();
        //this.calculadorRutas = Dijkstra();
    }
    
    public void actualizarListaGrafica() {
        DefaultComboBoxModel<Locacion> locacionesModel = new DefaultComboBoxModel<>();
        
        int i=0;
        
        for (Locacion l: listaLocaciones) {
            l.setId(i);
            i++;
        }
        
        for (Locacion loc: this.listaLocaciones) {
            locacionesModel.addElement(loc);
            i++;
        }
        
        this.locacionesList.setModel(locacionesModel);
    }
    
    public void prepararGrafo() {
        
    }

    public void dibujarTrazaCamino(Graphics2D g2d) {
        
        int penultimoPuntoId = (this.trazaRutaActual.size() - 1);
        
        if (this.trazaRutaActual.size() == 2) {
            DibujaFormas.dibujarAristaEntreLocaciones(g2d, this.origenSeleccionado, this.destinoSeleccionado, true);
            return;
        }
        
        
        for (int i=0; i< this.trazaRutaActual.size() - 1; i++) {
            
            int idLocacionOrigen = this.trazaRutaActual.get(i);
            
            Locacion origen = this.listaLocaciones.get(idLocacionOrigen);

            int idLocacionSiguiente = this.trazaRutaActual.get(i+1);
            Locacion siguiente = this.listaLocaciones.get(idLocacionSiguiente);
            
            //System.out.println("paso: " + idLocacionOrigen +" a destino: " + idLocacionSiguie);
            
            if (siguiente != null) {
                DibujaFormas.dibujarAristaEntreLocaciones(g2d, origen, siguiente, true);
            }
        }
    }
    
    public void dibujarAristasNodos(Graphics2D g2d) {
        
        Locacion loc1 = null;
        Locacion loc2 = null;
        
        for (int puntoOrigenId=0; puntoOrigenId < this.grafo.length; puntoOrigenId++) {
            loc1 = this.listaLocaciones.get(puntoOrigenId);
            
            for (int distanciaPuntoId=0; distanciaPuntoId < this.grafo.length; distanciaPuntoId++) {
                // se omite el nodo origen en la lectura de las distancias de la matriz de adyacencias
                if (puntoOrigenId != distanciaPuntoId) {
                    int distancia = this.grafo[puntoOrigenId][distanciaPuntoId];
                    if (distancia > 0) {
                        loc2 = this.listaLocaciones.get(distanciaPuntoId);
                        
                        DibujaFormas.dibujarAristaEntreLocaciones(g2d, loc1, loc2, false);
                    }
                }
            }
        }
    }
    
    public void dibujarPuntosMapa(Graphics2D g2d) {
        for (Locacion l: this.listaLocaciones) {
            DibujaFormas.dibujarPunto(g2d, l);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapaPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                AffineTransform at = g2d.getTransform();
                //at.scale(0.9, 0.9);
                at.translate(10, 10);

                g2d.setTransform(at);

                g2d.drawImage(imagenMapaITSON.getImage(), 0, 0, null);

                // opaca la imagen...
                g2d.setColor(new Color(0, 0, 0, 70));
                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

                // dibuja el mapa con sus nodos
                dibujarAristasNodos(g2d);

                if (dibujarCamino) {
                    dibujarTrazaCamino(g2d);
                    dibujarCamino = false;
                }

                dibujarPuntosMapa(g2d);

                //g2d.setTransform(at);
                //g2d.setColor(Color.BLACK);
                //g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        locacionesList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        botonAsignarDistancia = new javax.swing.JButton();
        botonCalcularDistancia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoDistanciaAprox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mapaPanelLayout = new javax.swing.GroupLayout(mapaPanel);
        mapaPanel.setLayout(mapaPanelLayout);
        mapaPanelLayout.setHorizontalGroup(
            mapaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        mapaPanelLayout.setVerticalGroup(
            mapaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        DefaultListModel<Locacion> modelo = new DefaultListModel<>();
        locacionesList.setModel(modelo);
        jScrollPane1.setViewportView(locacionesList);

        botonAsignarDistancia.setText("Asignar Distancia");
        botonAsignarDistancia.setEnabled(false);
        botonAsignarDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarDistanciaActionPerformed(evt);
            }
        });

        botonCalcularDistancia.setText("Calcular Distancia");
        botonCalcularDistancia.setEnabled(false);
        botonCalcularDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularDistanciaActionPerformed(evt);
            }
        });

        jLabel3.setText("Distancia (metros): ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonCalcularDistancia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAsignarDistancia))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDistanciaAprox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAsignarDistancia)
                    .addComponent(botonCalcularDistancia))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoDistanciaAprox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 154, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Puntos del mapa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Mapa ITSON Nainari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mapaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAsignarDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarDistanciaActionPerformed
        
        Locacion seleccionado = this.locacionesList.getSelectedValue();
        
        if (seleccionado == null) {
            return;
        }
        
        AsignarDistanciaDialog dlg = new AsignarDistanciaDialog(this, true, seleccionado, this.listaLocaciones);
        
    }//GEN-LAST:event_botonAsignarDistanciaActionPerformed

    private void botonCalcularDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularDistanciaActionPerformed
        Locacion seleccionado = this.locacionesList.getSelectedValue();
        
        if (seleccionado == null) {
            return;
        }
        
        CalcularDistanciaDialog dlg = new CalcularDistanciaDialog(this, true, seleccionado, this.listaLocaciones);
        
        this.origenSeleccionado = seleccionado;
 
        this.destinoSeleccionado = dlg.getDestino();
        
        Dijkstra dijkstra = new Dijkstra(this.grafo);
        
        try {
            this.trazaRutaActual = dijkstra.getTrazaBusquedaRutaMinima(this.origenSeleccionado.getId(), this.destinoSeleccionado.getId());
        } catch (Exception ex) {
            this.mapaPanel.repaint();
            this.campoDistanciaAprox.setText("");
            
            JOptionPane.showMessageDialog(
                    this, 
                    "No existe un camino para llegar a esa ruta", 
                    "Locacion desconocida", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        System.out.println(this.trazaRutaActual);
        
        this.dibujarCamino = true;
        
        int distanciaMetros = dijkstra.getDistanciaMinima(this.origenSeleccionado.getId(), this.destinoSeleccionado.getId());
        
        this.campoDistanciaAprox.setText(String.valueOf(distanciaMetros));
        
        
        this.mapaPanel.repaint();
    }//GEN-LAST:event_botonCalcularDistanciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RutasDijkstraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RutasDijkstraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RutasDijkstraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RutasDijkstraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RutasDijkstraFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAsignarDistancia;
    private javax.swing.JButton botonCalcularDistancia;
    private javax.swing.JTextField campoDistanciaAprox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Locacion> locacionesList;
    private javax.swing.JPanel mapaPanel;
    // End of variables declaration//GEN-END:variables
}
