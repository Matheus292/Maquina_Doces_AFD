/**
 * Tela Inicial da aplicação
 */
package projeto.interface_grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import projeto.logica_sistema.AFD;

/**
 * @authors Matheus Ribeiro Barbosa Santos 201516660 CCO3AN-MCA
 *  e Victor Renato Frutuoso Gama 201508677 CCO3AN-MCA
 **/

@SuppressWarnings("serial")
public class TelaInicial extends JFrame 
{

	//Atributos
	private JLabel lTitulo , lInserir ;
	public JLabel  lTotal;
	public JButton bFechar , bCancelar , bInserir , bNova ;
	public JRadioButton rDoces [ ] , rValor [ ] ;
	private String vDoces [ ] , vValor [ ] ;
	private JPanel centro , leste , oeste_centro , oeste_sul , leste_centro ;
	public ButtonGroup grupo , grupo1;
	private AFD afd ;


	/**
	 *Construtor Padrao
	 */
	public TelaInicial( )
	{
		//Chama o construtor da superclasse
		super( "Máquina de doces" );


		//Define o Layout da janela
		getContentPane( ).setLayout( new BorderLayout( 5 , 5 ) );

		//Instancia paineis
		instanciaJPanel( );		

		//Instancia os Componentes
		instanciaJLabel( );
		instanciaVetor( );
		instanciaJRadioButton( );
		instanciaJButton( );

		//Instancio o Objeto afd
		afd = new AFD( this );

		//Define as confgurações da janela
		setSize( 800 , 300 );
		setLocationRelativeTo( null ); //deixa a janela no centro da tela
		setResizable( false );//Não deixo redimensionar a janela
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}	

	/**
	 *Método get do atributo afd
	 *@return afd: AFD
	 */	
	public AFD getAfd( )
	{
		return afd;
	}

	/**
	 *Instancia JPanel 
	 */
	private void instanciaJPanel( )
	{
		//Instancia os paineis
		centro = new JPanel( new BorderLayout( ) );
		leste = new JPanel( new BorderLayout( ) );
		oeste_centro = new JPanel( new GridLayout( 3 , 1 ) );
		oeste_sul = new JPanel( new FlowLayout( ) );
		leste_centro = new JPanel( new GridLayout( 5 , 1 , 5 , 5 ) );


		//Adiciona os paineis ao container
		centro.add( oeste_sul , BorderLayout.SOUTH );
		centro.add( oeste_centro , BorderLayout.CENTER );
		leste.add( leste_centro , BorderLayout.CENTER );
		getContentPane( ).add( centro , BorderLayout.CENTER );
		getContentPane( ).add( leste , BorderLayout.EAST );		

	}

	/**
	 *Instancia Vetor
	 */
	public void instanciaVetor( )
	{
		vDoces = new String[ ]
				{
						"Bala de goma......... R$ 6,00" ,
						"Bolacha............... R$ 7,00" ,
						"Chocolate............. R$ 8,00"
				};

		vValor = new String [ ]
				{
						"R$ 1,00" , "R$ 2,00" , "R$ 5,00"
				};
	}

	/**
	 *Instancia elementos JLabel
	 */
	private void instanciaJLabel( )
	{		
		lTitulo = new JLabel( " Escolha uma das opções" );
		lTitulo.setFont( new Font( "Arial" , 1 , 20 ) );
		centro.add( lTitulo , BorderLayout.NORTH );


		lInserir = new JLabel( "Insira cédulas de R$ 1 , R$ 2 ou R$ 5   " );
		lInserir.setFont( new Font( "Arial" , 1 , 20 ) );
		leste.add( lInserir , BorderLayout.NORTH );


		lTotal = new JLabel( "Estado Atual: "  );
		lTotal.setFont( new Font( "Arial" , 1 , 20 ) );
		leste.add( lTotal , BorderLayout.SOUTH );

	}

	/**
	 *Instancia elemento JButton
	 */
	private void instanciaJButton( )
	{
		bFechar = new JButton( "Finalizar Compra" );
		bFechar.addActionListener( new Evento( this ) );
		bFechar.setEnabled( false ); //Inicio com este botão desabilitado
		oeste_sul.add( bFechar );

		bCancelar = new JButton( "Cancelar Compra" );
		bCancelar.addActionListener( new Evento( this ) );
		bCancelar.setEnabled( false ); //Inicio com este botão desabilitado
		oeste_sul.add( bCancelar );

		bNova = new JButton( "Nova Compra" );
		bNova.addActionListener( new Evento( this ) );
		oeste_sul.add( bNova );

		bInserir = new JButton( "Inserir" );
		bInserir.addActionListener( new Evento( this ) );
		bInserir.setEnabled( false ); //Inicio com este botão desabilitado
		leste_centro.add( bInserir );
	}

	/**
	 *Instancia elementos JRadioButton
	 */
	private void instanciaJRadioButton( )
	{
		//Instancia os JRadioButton para selecionar o doce
		grupo = new ButtonGroup( );
		rDoces = new JRadioButton [ vDoces.length ];

		for( int i = 0 ; i < rDoces.length ; i++ )
		{
			rDoces[ i ] = new JRadioButton( vDoces[ i ] );
			rDoces[ i ].setEnabled( false ); //Deixo desabilitado
			rDoces[ i ].addItemListener( new Evento( this ) );
			grupo.add( rDoces[ i ] );
			oeste_centro.add( rDoces [ i ] );
		}

		//Instancia os JRadioButton para indicar o valor a ser inserido
		grupo1 = new ButtonGroup( );      
		rValor = new JRadioButton[ vValor.length ];

		for( int i = 0 ; i < rValor.length ; i ++ )
		{
			rValor[ i ] = new JRadioButton( vValor[ i ] );
			rValor[ i ].addItemListener( new Evento( this ) );
			rValor[ i ].setEnabled( false ); //Deixo desabilitado
			grupo1.add( rValor[ i ] );
			leste_centro.add( rValor[ i ] );

		} 
	}
}//Fim da classe