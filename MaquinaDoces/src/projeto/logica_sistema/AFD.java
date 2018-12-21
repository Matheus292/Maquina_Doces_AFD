/**
 * Classe Responsável por simular o afd da máquina de doces
 */
package projeto.logica_sistema;


import javax.swing.JOptionPane;

import projeto.interface_grafica.TelaInicial;

/**
 * @authors Matheus Ribeiro Barbosa Santos 201516660 CCO3AN-MCA
 *  e Victor Renato Frutuoso Gama 201508677 CCO3AN-MCA
 *
 */
public class AFD 
{

	//Atributo
	private int estado;

	@SuppressWarnings("unused")
	private String doceEstado;

	private TelaInicial window;


	/**
	 *Construtor Não Padrão
	 *@param window : TelaInicial
	 */
	public AFD( TelaInicial window )
	{
		this.window = window; 

		//Chama o inicializa, que é responsavel por deixar no Q0 e o total inserido igual a 0.00
		inicializa( );		
	}

	/**
	 *Metodo que retorna o estado
	 *@return estado : int
	 */
	public int getEstado( )
	{
		return estado;
	}


	/**
	 *Aqui inicializa os estados
	 */
	public void inicializa( )
	{
		estado = Estado.Q0; //Inicializa com  R$ 0,00
		doceEstado = null ; //Inicializa nulo			
	}



	/**
	 *Metodo responsavel por controlar os estados
	 */
	public void controlarEstados( String inserido )
	{
		switch( estado )
		{
		case Estado.Q0:
			Q0( Integer.parseInt( inserido ) );
			break;

		case Estado.Q1:
			Q1( Integer.parseInt( inserido ) );
			break;

		case Estado.Q2:
			Q2( Integer.parseInt( inserido ) );
			break;

		case Estado.Q3:
			Q3( Integer.parseInt( inserido ) );
			break;

		case Estado.Q4:
			Q4( Integer.parseInt( inserido ) );
			break;

		case Estado.Q5:
			Q5( Integer.parseInt( inserido ) );
			break;

		case Estado.Q6:
			Q6( inserido );
			break;
		case Estado.Q7:
			Q7( inserido );
			break;

		case Estado.Q8:
			Q8( inserido );
			break;

		case Estado.Q9:
			Q9( inserido );
			break;
		}
	}



	/**
	 *Método responsavel pelo estado QO
	 *
	 *se inserir R$ 1,00 vai para Q1
	 *se inserir R$ 2,00 vai para Q2
	 *se inserir R$ 5,00 vai para Q5
	 *
	 *@param valor
	 */
	public void Q0( int valor )
	{
		switch( valor )
		{
		case 1:
			estado = Estado.Q1;
			window.lTotal.setText( "Estado Atual: Q1" );
			break;
		case 2:
			estado = Estado.Q2;
			window.lTotal.setText( "Estado Atual: Q2" );
			break;
		case 5:
			estado = Estado.Q5;
			window.lTotal.setText( "Estado Atual: Q5 " );
			break;
		}

	}

	/**
	 *Método responsavel pelo estado Q1
	 *
	 *se inserir R$ 1,00 vai para Q2
	 *se inserir R$ 2,00 vai para Q3
	 *se inserir R$ 5,00 vai para Q6
	 *
	 *@param valor
	 */
	public void Q1( int valor )
	{

		switch( valor )
		{
		case 1:
			estado = Estado.Q2;
			window.lTotal.setText( "Estado Atual: Q2 " );
			break;
		case 2:
			estado = Estado.Q3;
			window.lTotal.setText( "Estado Atual: Q3 " );
			break;
		case 5:
			estado = Estado.Q6;
			window.lTotal.setText( "Estado Atual: Q6 " );
			window.rDoces[ 0 ].setEnabled( true );
			break;
		}
	}

	/**
	 *Método responsavel pelo estado Q2
	 *
	 *se inserir R$ 1,00 vai para Q3
	 *se inserir R$ 2,00 vai para Q4
	 *se inserir R$ 5,00 vai para Q7
	 *
	 *@param valor
	 */
	public void Q2( int valor )
	{
		switch( valor )
		{
		case 1:
			estado = Estado.Q3;
			window.lTotal.setText( "Estado Atual: Q3" );
			break;
		case 2:
			estado = Estado.Q4;
			window.lTotal.setText( "Estado Atual: Q4" );
			break;
		case 5:
			estado = Estado.Q7;
			window.lTotal.setText( "Estado Atual: Q7" );
			window.rDoces[ 0 ].setEnabled( true );
			window.rDoces[ 1 ].setEnabled( true );
			break;
		}
	}

	/**
	 *Método responsavel pelo estado Q3
	 *
	 *se inserir R$ 1,00 vai para Q4
	 *se inserir R$ 2,00 vai para Q5
	 *se inserir R$ 5,00 vai para Q8
	 *
	 *@param valor
	 */
	public void Q3( int valor )
	{
		switch( valor )
		{
		case 1:
			estado = Estado.Q4;
			window.lTotal.setText( "Estado Atual: Q4" );
			break;
		case 2:
			estado = Estado.Q5;
			window.lTotal.setText( "Estado Atual: Q5" );
			break;
		case 5:
			estado = Estado.Q8;
			window.lTotal.setText( "Estado Atual: Q8 " );
			window.rDoces[ 0 ].setEnabled( true );
			window.rDoces[ 1 ].setEnabled( true );
			window.rDoces[ 2 ].setEnabled( true );
			break;
		}
	}

	/**
	 *Método responsavel pelo estado Q4
	 *
	 *se inserir R$ 1,00 vai para Q5
	 *se inserir R$ 2,00 vai para Q6
	 *se inserir R$ 5,00 vai para Q9
	 *
	 *@param valor
	 */
	public void Q4( int valor )
	{
		switch( valor )
		{
		case 1:
			estado = Estado.Q5;
			window.lTotal.setText( "Estado Atual: Q5" );
			break;
		case 2:
			estado = Estado.Q6;
			window.lTotal.setText( "Estado Atual: Q6" );
			window.rDoces[ 0 ].setEnabled( true );
			break;
		case 5:
			estado = Estado.Q9;
			window.lTotal.setText( "Estado Atual: Q9" );
			window.rDoces[ 0 ].setEnabled( true );
			window.rDoces[ 1 ].setEnabled( true );
			window.rDoces[ 2 ].setEnabled( true );
			break;
		}
	}


	/**
	 *Método responsavel pelo estado Q5
	 *
	 *se inserir R$ 1,00 vai para Q6
	 *se inserir R$ 2,00 vai para Q7
	 *se inserir R$ 5,00 vai para Q9
	 *
	 *@param valor
	 */
	public void Q5( int valor )
	{
		switch( valor )
		{
		case 1:
			estado = Estado.Q6;
			window.lTotal.setText( "Estado Atual: Q6" );
			break;
		case 2:
			estado = Estado.Q7;
			window.lTotal.setText( "Estado Atual: Q7" );
			window.rDoces[ 1 ].setEnabled( true );		
			break;
		case 5:
			estado = Estado.Q9;
			window.lTotal.setText( "Estado Atual: Q9" );
			window.rDoces[ 1 ].setEnabled( true );		
			window.rDoces[ 2 ].setEnabled( true );		
			break;			
		}


		//Como a partir do Q6 eu posso comprar bala de goma então eu posso deixar a escolha de bala de goma habilitada
		window.rDoces[ 0 ].setEnabled( true );			
	}

	/**
	 *Método responsavel pelo estado Q6
	 *
	 *se inserir R$ 1,00 vai para Q7
	 *se inserir R$ 2,00 vai para Q8
	 *se inserir R$ 5,00 vai para Q9
	 *
	 *se inserir a letra --> A <-- envia para Q10 ( Bala de Goma sem troco )
	 *
	 *o metodo possui um try catch.
	 * pois ele tentara fazer o casting, se não conseguiu seberá que foi escolhido o item e executará o catch
	 *
	 *@param valor
	 */
	public void Q6( String valor )
	{
		try
		{
			int tentativa = Integer.parseInt( valor );

			switch( tentativa )
			{
			case 1:
				estado = Estado.Q7;
				window.lTotal.setText( "Estado Atual: Q7" );
				break;
			case 2:
				estado = Estado.Q8;
				window.lTotal.setText( "Estado Atual: Q8" );
				window.rDoces[ 2 ].setEnabled( true );		

				break;
			case 5:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				window.rDoces[ 2 ].setEnabled( true );		
				break;
			}

			//Como a partir do Q7 eu posso comprar bala de goma e bolacha então eu posso deixar a
			// escolha de bala de goma e bolacha habilitadas
			window.rDoces[ 0 ].setEnabled( true );	
			window.rDoces[ 1 ].setEnabled( true );			
		}
		catch( NumberFormatException e ) //Se ele não conseguiu fazer o casting
		{
			//Como está no Q6( R$ 6.00 ) só poderá comprar a bala de goma
			doceEstado = Estado.Q10;
			Q10( ); //Chama o metodo Q10
		}

	}

	/**
	 *Método responsavel pelo estado Q7
	 *
	 *se inserir R$ 1,00 vai para Q8
	 *se inserir R$ 2,00 vai para Q9
	 *se inserir R$ 5,00 vai para Q9
	 *
	 *se inserir ---> B <--- vai para Q11 ( Bala de Goma com troco )
	 *se inserir ---> C <--- vai para Q12 ( Bolacha sem troco )
	 *
	 *o metodo possui um try catch.
	 * pois ele tentara fazer o casting, se não conseguiu seberá que foi escolhido o item e executará o catch
	 *
	 *
	 *@param inserido
	 */
	public void Q7( String inserido )
	{

		try
		{
			int valor = Integer.parseInt( inserido );

			switch( valor )
			{
			case 1:
				estado = Estado.Q8;
				window.lTotal.setText( "Estado Atual: Q8" );
				break;
			case 2:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
					break;
			case 5:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			}			
			//Como a partir do Q7 eu posso comprar bala de goma , bolacha e chocolate então eu posso deixar a
			// escolha de bala de goma , bolacha e chocolate habilitadas
			window.rDoces[ 0 ].setEnabled( true );	
			window.rDoces[ 1 ].setEnabled( true );			
			window.rDoces[ 2 ].setEnabled( true );
			
		}
		catch( NumberFormatException e )
		{
			switch ( inserido  )
			{
			case "B":
				doceEstado = Estado.Q11;
				Q11( ); //Executa o metodo Q11
				break;
			case "C":
				doceEstado = Estado.Q12;
				Q12( ); //Executa o metodo Q12
				break;
			}
		}
	}

	/**
	 *Método responsavel pelo estado Q8
	 *
	 *se inserir R$ 1,00 vai para Q9
	 *se inserir R$ 2,00 vai para Q9
	 *se inserir R$ 5,00 vai para Q9
	 *
	 *
	 *se inserir ---> B <--- vai para Q11 ( Bala de Goma com troco )
	 *se inserir ---> D <--- vai para Q13 ( Bolacha com troco )
	 *se inserir ---> E <--- vai para Q14 ( Chocolate sem troco )
	 * 
	 *o metodo possui um try catch.
	 * pois ele tentara fazer o casting, se não conseguiu seberá que foi escolhido o item e executará o catch
	 *
	 *@param inserido
	 */	
	public void Q8( String inserido )
	{
		try
		{

			int valor = Integer.parseInt( inserido );


			switch( valor )
			{
			case 1:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			case 2:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			case 5:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			}

			//Como a partir do Q8 eu posso comprar bala de goma , bolacha e chocolate. Então eu posso deixar a
			// escolha de bala de goma , bolacha e chocolate habilitadas
			window.rDoces[ 0 ].setEnabled( true );	
			window.rDoces[ 1 ].setEnabled( true );
			window.rDoces[ 2 ].setEnabled( true );

		}
		catch( NumberFormatException e )
		{
			switch ( inserido )
			{
			case "B":
				doceEstado = Estado.Q11;
				window.lTotal.setText( "Estado Atual: Q11" );
				Q11( ); //Executa Q11
				break;

			case "D":
				doceEstado = Estado.Q13;
				window.lTotal.setText( "Estado Atual: Q13" );
				Q13( );//Executa Q13
				break;

			case "E":
				doceEstado = Estado.Q14;
				window.lTotal.setText( "Estado Atual: Q14" );
				Q14( ); //Executa Q14
				break;
			}
		}
	}

	/**
	 *Método responsavel pelo estado Q9
	 *
	 *se inserir R$ 1,00 vai para Q9
	 *se inserir R$ 2,00 vai para Q9
	 *se inserir R$ 5,00 vai para Q9
	 *
	 *se inserir ---> B <--- vai para Q11 ( Bala de Goma com troco )
	 *se inserir ---> D <--- vai para Q13 ( Bolacha com troco )
	 *se inserir ---> F <--- vai para Q15 ( Chocolate com troco )
	 *
	 *@param inserido
	 */	
	public void Q9( String inserido )
	{
		try
		{
			int valor = Integer.parseInt( inserido );

			switch( valor )
			{
			case 1:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			case 2:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			case 5:
				estado = Estado.Q9;
				window.lTotal.setText( "Estado Atual: Q9" );
				break;
			}

			//Como a partir do Q8 eu posso comprar bala de goma , bolacha e chocolate. Então eu posso deixar a
			// escolha de bala de goma , bolacha e chocolate habilitadas
			window.rDoces[ 0 ].setEnabled( true );	
			window.rDoces[ 1 ].setEnabled( true );
			window.rDoces[ 2 ].setEnabled( true );

		}
		catch( NumberFormatException e )
		{
			switch ( inserido )
			{
			case "B":
				doceEstado = Estado.Q11;
				window.lTotal.setText( "Estado Atual: Q11" );
				Q11( ); //Executa Q11
				break;

			case "D":
				doceEstado = Estado.Q13;
				window.lTotal.setText( "Estado Atual: Q13" );
				Q13( );//Executa Q13
				break;

			case "F":
				doceEstado = Estado.Q15;
				window.lTotal.setText( "Estado Atual: Q15" );
				Q15( ); //Executa Q15
				break;
			}
		}
	}

	/**
	 *Método responsavel pelo estado Q10
	 *
	 *Item Comprado: Bala de goma sem troco
	 *
	 *@param inserido
	 */	

	public void Q10( )
	{
		window.lTotal.setText( "Estado Atual: Q10" );

		//Mostra na tela o que foi comprado
		JOptionPane.showMessageDialog
		( window ,  "Item comprado: Bala de Goma \n Troco: Não Possui \n ****** Volte Sempre****" , "Compra realizada com sucesso" , 1 );

	}

	/**
	 *Método responsavel pelo estado Q11
	 *
	 *Item Comprado: Bala de goma com troco
	 *
	 *@param inserido
	 */	
	public void Q11( )
	{
		window.lTotal.setText( "Estado Atual: Q11" );

		//Mostra na tela o que foi comprado
		JOptionPane.showMessageDialog
		( window ,  "Item comprado: Bala de Goma \n Troco: Possui \n ****** Volte Sempre****" , "Compra realizada com sucesso" , 1 );

	}

	/**
	 *Método responsavel pelo estado Q12
	 *
	 *Item Comprado: Bolacha sem troco
	 *
	 *@param inserido
	 */	
	public void Q12( )
	{
		window.lTotal.setText( "Estado Atual: Q12" );

		//Mostra na tela o que foi comprado
		JOptionPane.showMessageDialog
		( window ,  "Item comprado: Bolacha \n Troco: Não Possui \n ****** Volte Sempre****" , "Compra realizada com sucesso" , 1 );

	}

	/**
	 *Método responsavel pelo estado Q13
	 *
	 *Item Comprado: Bolacha com troco
	 *
	 *@param inserido
	 */	
	public void Q13( )
	{
		window.lTotal.setText( "Estado Atual: Q13" );

		//Mostra na tela o que foi comprado
		JOptionPane.showMessageDialog
		( window ,  "Item comprado: Bolacha \n Troco: Possui \n ****** Volte Sempre****" , "Compra realizada com sucesso" , 1 );

	}

	/**
	 *Método responsavel pelo estado Q14
	 *
	 *Item Comprado: Chocolate sem troco
	 *
	 *@param inserido
	 */	
	public void Q14( )
	{
		window.lTotal.setText( "Estado Atual: Q14" );

		//Mostra na tela o que foi comprado
		JOptionPane.showMessageDialog
		( window ,  "Item comprado: Chocolate \n Troco: Não Possui \n ****** Volte Sempre****" , "Compra realizada com sucesso" , 1 );

	}

	/**
	 *Método responsavel pelo estado Q15
	 *
	 *Item Comprado: Chocolate com troco
	 *
	 *@param inserido
	 */	
	public void Q15( )
	{
		window.lTotal.setText( "Estado Atual: Q15" );

		//Mostra na tela o que foi comprado
		JOptionPane.showMessageDialog
		( window ,  "Item comprado: Chocolate \n Troco: Possui \n ****** Volte Sempre****" , "Compra realizada com sucesso" , 1 );

	}
}//Fim da classe