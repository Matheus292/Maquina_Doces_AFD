/**
 * Responsavel por tratar os eventos dos componentes gráficos da classe TelaInicial
 */
package projeto.interface_grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *  @authors Matheus Ribeiro Barbosa Santos 201516660 CCO3AN-MCA
 *  e Victor Renato Frutuoso Gama 201508677 CCO3AN-MCA
 **/

public class Evento implements ActionListener , ItemListener 
{

	//Atributo
	private TelaInicial window;


	/**
	 * Construtor Padrão
	 */
	public Evento( TelaInicial window )
	{
		this.window = window;

	}

	/**
	 *Responsavel por tratar eventos dos radio buttons que inserem valor( R$ 1 , R$ 2 , R$ 5 )
	 *
	 *@param ActionEvent evento
	 */
	public void itemStateChanged( ItemEvent evento )
	{
		for( int i = 0 ; i < window.rValor.length ; i ++ )
			if( window.rValor[ i ].isSelected( ) )
				window.bInserir.setEnabled( true ); //Quando o usuário decidir o valor o botão inserir estará habilitado

		
		for( int i = 0 ; i < window.rDoces.length ; i++ )
		{
			if( window.rDoces[ i ].isSelected( ) )
				window.bFechar.setEnabled( true );
		}
		
	}
	


/**
 *Responsável por tratar os eventos dos botões
 *@param ActionEvent evento
 */
@Override
public void actionPerformed( ActionEvent evento )
{
	if( evento.getSource( ) == window.bNova )
	{
		window.lTotal.setText( "Estado Atual:  Q0 " );

		window.getAfd( ).inicializa( );

		//Deixo os itens ficarem não selecionados 
		window.grupo.clearSelection( );	
		window.grupo1.clearSelection( );

		//Deixo alguns recursos habilitados
		window.bCancelar.setEnabled( true );

		for( int i = 0 ; i < window.rValor.length ; i ++ )
			window.rValor[ i ].setEnabled( true );

		for( int i = 0 ; i < window.rDoces.length ; i++ )
			window.rDoces[ i ].setEnabled( false );

		//Deixo o botão de nova compra desabilitados
		window.bNova.setEnabled( false );

	}//Fim do if		

	if( evento.getSource( ) == window.bCancelar )
	{
		window.lTotal.setText( "Estado Atual: " );

		//Deixo os itens ficarem não selecionados 
		window.grupo.clearSelection( );		
		window.grupo1.clearSelection( );

		//Desabilito alguns recursos da janela
		window.bCancelar.setEnabled( false );
		window.bFechar.setEnabled( false );
		window.bInserir.setEnabled( false );

		for( int i = 0 ; i < window.rValor.length ; i ++ )
			window.rValor[ i ].setEnabled( false );

		for( int i = 0 ; i < window.rDoces.length ; i ++ )
			window.rDoces[ i ].setEnabled( false );

		//Habilito o botão de nova compra
		window.bNova.setEnabled( true );

	}//fim do if

	if( evento.getSource( ) == window.bFechar )
	{

		//Se foi selecionado a bala de goma, se o estado atual for Q6 ele insere A( Bala de goma sem troco )
		//Senão , o Estado atual pode ser de Q7 pra cima , então envio B ( Bala de goma com troco )
		if( window.rDoces[ 0 ].isSelected( ) )
		{
			if( window.getAfd( ).getEstado( ) == 6 )
				window.getAfd( ).controlarEstados( "A" );
			else
				window.getAfd( ).controlarEstados( "B" );
		}

		else
		{
			//Se foi selecionado a bolacha, se o estado atual for Q7 ele insere C( Bolacha sem troco )
			//Senão , o Estado atual pode ser de Q8 pra cima , então envio D ( Bolacha com troco )
			if( window.rDoces[ 1 ].isSelected( ) )
			{
				if( window.getAfd( ).getEstado( ) == 7 )
					window.getAfd( ).controlarEstados( "C" );
				else
					window.getAfd( ).controlarEstados( "D" );
			}
			else
			{
				//Se foi selecionado o chocolate, se o estado atual for Q8 ele insere E( Chocolate sem troco )
				//Senão , o Estado atual pode ser de Q9 , então envio F ( Chocolate com troco )
				if( window.getAfd( ).getEstado( ) == 8 )
					window.getAfd( ).controlarEstados( "E" );
				else
					window.getAfd( ).controlarEstados( "F" );
			}
		}

		//Desabilito alguns recursos
		window.bCancelar.setEnabled( false );
		window.bFechar.setEnabled( false );

		for( int i = 0 ; i < window.rValor.length ; i ++ )
			window.rValor[ i ].setEnabled( false );
		
		for( int i = 0 ; i < window.rDoces.length ; i ++ )
			window.rDoces[ i ].setEnabled( false );


		//Habilito o Botão de nova compra
		window.bNova.setEnabled( true );

	}//fim do if

	if( evento.getSource( ) == window.bInserir )
	{
		//Aqui pega qual valor foi inserido
		int valor  = ( window.rValor[ 0 ].isSelected( ) ? 1 : ( window.rValor[ 1 ].isSelected( ) ? 2 : 5  ) );

		//insere valor na maquina
		window.getAfd( ).controlarEstados( "" + valor );


		//Deixa os JRadioButtons que inserem valor ficarem não selecionados
		window.grupo1.clearSelection( );

		//Desabilita o próprio componente
		window.bInserir.setEnabled( false );



	}//fim do if

}
}//Fim da classe