import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JingeriaStart extends JFrame implements ActionListener  {
	

	java.util.Timer timer;  
	
    int countdown;
		
	Point pp = new Point();
	JingeriaDAO dao = new JingeriaDAO();
	

	JFrame roadingFrame, gameFrame,gamePlayFrame, rulesFrame,endingFrame,lastEndingFrame;
	JPanel roadingBackground, gameBackground, rulesPanel, gamePlayBackground,spongeBob, squidward, krabs, customer1,customer2,customer3,customer4;
	JPanel table, pattyImg, vegetablesImg, bunImg, checkBoard,burgerImg, board, checkPanel,blackBoard, failImg,successImg, ResultBoard;
	JButton play, produce,consume1, consume2, consume3, consume4, end;
	JButton gameRules, rulesOut, pattyButton, vegetablesButton, bunButton;  
	JLabel Loading, askedLevel, levelCount, patty, vegetables, bun, askedBurgerNum, pattyNum, vegetablesNum,bunNum;
	JLabel  consumer1Level1Result, consumer2Level1Result, consumer1Level2Result, consumer2Level2Result, consumer3Level2Result,
	consumer1Level3Result, consumer2Level3Result, consumer3Level3Result, consumer4Level3Result,consumer1Text,consumer2Text,consumer3Text,consumer4Text,level1Text,level2Text,level3Text;
	JLabel burger, burgerNum, burgerConsume1, burgerConsumeNum1, burgerConsume2, burgerConsumeNum2, burgerConsume3, burgerConsumeNum3,burgerConsume4, burgerConsumeNum4;
	JLabel time,check;
	boolean isGameStart = false; // false ���� true ��ŸƮ

	int level1ConsumeNum1;
	int level1ConsumeNum2;
	int level1ConsumeNum3;
	int level1ConsumeNum4;
	int level2ConsumeNum1;
	int level2ConsumeNum2;
	int level2ConsumeNum3;
	int level2ConsumeNum4;
	int level3ConsumeNum1;
	int level3ConsumeNum2;
	int level3ConsumeNum3;
	int level3ConsumeNum4;

	public JingeriaStart() {
		
		roadingFrame = new JFrame("ROADING"); 
		gameFrame = new JFrame("JINGERIA");
		gamePlayFrame = new JFrame("PLAYING");
		rulesFrame = new JFrame("RULES");
		endingFrame = new JFrame();
		lastEndingFrame = new JFrame();
		
		play = new JButton("PLAY");
		play.setBackground(Color.WHITE);
		play.setForeground(Color.BLACK);
		play.setFont(new Font("�޸����",Font.BOLD,30));
		play.setBounds(80, 630, 200, 50);
		play.addActionListener(this);
		
		gameRules  = new JButton("RULES");
		gameRules.setBackground(Color.WHITE);
		gameRules.setForeground(Color.BLACK);
		gameRules.setFont(new Font("�޸����",Font.BOLD,30));
		gameRules.setBounds(80, 690, 200, 50);
		gameRules.addActionListener(this);
		
		rulesOut = new JButton("OUT");
		rulesOut.setBackground(Color.WHITE);
		rulesOut.setForeground(Color.BLACK);
		rulesOut.setFont(new Font("�޸����",Font.BOLD,15));
		rulesOut.setBounds(1000, 710, 100, 50);
		rulesOut.addActionListener(this);
		
	    produce = new JButton("PRODUCE");
        produce.setBackground(Color.WHITE);
        produce.setForeground(Color.BLACK);
        produce.setFont(new Font("�޸����",Font.BOLD,15));
		produce.setBounds(1000, 800, 200, 50);
		produce.addActionListener(this);
		
	    consume1 = new JButton("(�մ�1)CONSUME");
	    consume1.setBackground(Color.WHITE);
	    consume1.setForeground(Color.BLACK);
	    consume1.setFont(new Font("�޸����",Font.BOLD,15));
		consume1.addActionListener(this);

		consume2 = new JButton("(�մ�2)CONSUME");
		consume2.setBackground(Color.WHITE);
		consume2.setForeground(Color.BLACK);
		consume2.setFont(new Font("�޸����",Font.BOLD,15));
		consume2.addActionListener(this);

		consume3 = new JButton("(�մ�3)CONSUME");
		consume3.setBackground(Color.WHITE);
		consume3.setForeground(Color.BLACK);
		consume3.setFont(new Font("�޸����",Font.BOLD,15));
		consume3.addActionListener(this);
		
		consume4 = new JButton("(�մ�4)CONSUME");
		consume4.setBackground(Color.WHITE);
		consume4.setForeground(Color.BLACK);
		consume4.setFont(new Font("�޸����",Font.BOLD,15));
		consume4.addActionListener(this);

	    pattyButton = new JButton("PATTY");
	    pattyButton.setBackground(Color.WHITE);
	    pattyButton.setForeground(Color.BLACK);
	    pattyButton.setFont(new Font("�޸����",Font.BOLD,15));
		pattyButton.setBounds(200, 420, 100, 50);
		pattyButton.addActionListener(this);

		vegetablesButton = new JButton("VEGETABLES");
		vegetablesButton.setBackground(Color.WHITE);
		vegetablesButton.setForeground(Color.BLACK);
        vegetablesButton.setFont(new Font("�޸����",Font.BOLD,15));
		vegetablesButton.setBounds(400, 420, 200, 50);
		vegetablesButton.addActionListener(this);
		
		bunButton = new JButton("BUN");
		bunButton.setBackground(Color.WHITE);
		bunButton.setForeground(Color.BLACK);
		bunButton.setFont(new Font("�޸����",Font.BOLD,15));
		bunButton.setBounds(680, 420, 100, 50);
		bunButton.addActionListener(this);
		
		end = new JButton("END");
		end.setBackground(Color.WHITE);
		end.setForeground(Color.BLACK);
		end.setFont(new Font("�޸����",Font.BOLD,30));
		end.setBounds(50, 200, 200, 50);
		end.addActionListener(this);
			
		roadingBackground = new JPanel(){ ImageIcon i = new ImageIcon("img/Sky.jpg");	// �ε� ���
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 1250, 1000, null);
		}
	    };
	    roadingBackground.setLayout(null);
	   
	    gameBackground = new JPanel(){ImageIcon i = new ImageIcon("img/Jingeria.jpg");	// �ε� ���� ���� ���� ���
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 1250, 1000, null);
		}
	    };
	    gameBackground.setLayout(null);
	   
	    rulesPanel = new JPanel(){ImageIcon i = new ImageIcon("img/rulesImg.jpg");	 // ���� ��� ���� ���
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 1250, 1000, null);
			}
	    };	
		rulesPanel.setLayout(null);
		
		gamePlayBackground = new JPanel(){ImageIcon i = new ImageIcon("img/Kitchen.jpg");	 // ���� �÷��� ���
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 1300, 700, null);
			}
	    };
	    gamePlayBackground.setLayout(null);
	    
	    failImg = new JPanel(){ImageIcon i = new ImageIcon("img/FailImg.png");	 // ����
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 1250, 1000, null);
			}
	    };
	    failImg.setLayout(null);
	    
	    successImg = new JPanel(){ImageIcon i = new ImageIcon("img/SuccessImg.png");	 // ���� 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 1250, 1000, null);
			}
	    };
	    successImg.setLayout(null);
		
	    spongeBob = new JPanel(){ ImageIcon i = new ImageIcon("img/SpongeBobImg.png");	 // ��������
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 150, 150, this);
		} 
	    }; 
	    spongeBob.setBounds(200, 180, 200, 500); 
	
	    squidward =  new JPanel(){ ImageIcon i = new ImageIcon("img/SquidwardImg.png");	 // ¡¡��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 150, 250, null);
		} 
	    };  
	    squidward.setBounds(400, 100, 200, 500); 
		
	    krabs = new JPanel(){ ImageIcon i = new ImageIcon("img/krabsImg.png");	 // ���Ի���
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 250, 250, null);
		}
	    }; 
	    krabs.setBounds(600, 110, 400, 800); 
	    
	    board = new JPanel(){ ImageIcon i = new ImageIcon("img/DarkTree.jpg");	 // ���� ��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 700, 1000, null);
		}
	    }; 
	    board.setBounds(950, 0, 700, 3000);
	    board.setLayout(null);
	    
	    table = new JPanel(){ ImageIcon i = new ImageIcon("img/BrightTree.jpg");	 // ��� �غ� ��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 950, 1000, null);
		}
	    };
	    table.setBounds(0, 300, 2000, 700); 
		
	    pattyImg = new JPanel(){ ImageIcon i = new ImageIcon("img/PattyImg.png");	  // ��Ƽ 
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 150, 150, null);
		}
	    };
	    pattyImg.setBounds(200, 300, 200, 200); 

	    
	    vegetablesImg = new JPanel(){ ImageIcon i = new ImageIcon("img/VegetablesImg.png");	// ä��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 300, 350, null);
		}
	    }; 
	    vegetablesImg.setBounds(370, 180, 400, 400); 
	    
	    bunImg = new JPanel(){ ImageIcon i = new ImageIcon("img/BunImg.png");	// ��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 230, null);
		}
	    }; 
	
	    bunImg.setBounds(630, 260, 200, 200); 

	    customer1 = new JPanel(){ ImageIcon i = new ImageIcon("img/PatrickImg.png");	// ����(�մ�1:����1)
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 150, 250, null);
		}
	    }; 
	    customer1.setBounds(270, 500, 1500, 1000);
	    
	    customer2 = new JPanel(){ ImageIcon i = new ImageIcon("img/PatrickImg.png");	// ����(�մ�2:����1)
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 150, 250, null);
		}
	    }; 
	    customer2.setBounds(600, 500, 1500, 1000);
	    
	    customer3 = new JPanel(){ ImageIcon i = new ImageIcon("img/GaryImg.png");	//  ������(�մ�3:����2)
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 200, null);
		}
	    }; 
	    customer3.setBounds(250, 720, 500, 500);
	    
	    customer4 = new JPanel(){ ImageIcon i = new ImageIcon("img/CockroachImg.png");	// ��������2(�մ�4:����3)
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 200, null);
		}
	    }; 
	    customer4.setBounds(570, 720, 500, 500);
	    
	    checkBoard = new JPanel(){ ImageIcon i = new ImageIcon("img/White.png");	// ���� Ȯ��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 280, null);
		}
	    }; 
	    checkBoard.setBounds(50, 290, 220, 550); 
		checkBoard.setLayout(null);
	    
		burgerImg = new JPanel(){ ImageIcon i = new ImageIcon("img/BurgerImg.png");	 // �Ի����
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 400, null);
		}
	    }; 	  
	    burgerImg.setBounds(45, 500, 250, 500); 
	    
	    blackBoard = new JPanel(){ImageIcon i = new ImageIcon("img/BlackBoard.png");	 // ���� �˸� ��
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 100, null);
			}
	    };
	    blackBoard.setBounds(950, 150, 300, 50); 
	     
	    ResultBoard = new JPanel(){ ImageIcon i = new ImageIcon("img/White.png");	// ���� Ȯ��
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 1000, 500, null);
		}
	    }; 
	    ResultBoard.setBounds(70, 420, 750, 500); 
	    ResultBoard.setLayout(null);
		
	    time = new JLabel("30");
	    time.setOpaque(false);
	    time.setFont(new Font("�޸����",Font.BOLD,50));
	    time.setHorizontalAlignment(SwingConstants.CENTER);
	    time.setForeground(new Color(0,0,0));
	    time.setBounds(100,20,100,100); 
	    
		askedLevel = new JLabel("LEVEL:");
		askedLevel.setOpaque(false);
		askedLevel.setFont(new Font("�޸����",Font.BOLD,50));
		askedLevel.setHorizontalAlignment(SwingConstants.CENTER);
		askedLevel.setForeground(new Color(255,0,0));
		askedLevel.setBounds(-120, 20, 500, 100);	
		
		levelCount = new JLabel("");
		levelCount.setOpaque(false);
		levelCount.setFont(new Font("�޸����",Font.BOLD,50));
		levelCount.setHorizontalAlignment(SwingConstants.CENTER);
		levelCount.setForeground(new Color(255,0,0));
		levelCount.setBounds(0, 20, 500, 100);	
	
		askedBurgerNum = new JLabel("GoalNum: Five each");
		askedBurgerNum.setOpaque(false);
		askedBurgerNum.setFont(new Font("�޸����",Font.BOLD,50));
		askedBurgerNum.setHorizontalAlignment(SwingConstants.CENTER);
		askedBurgerNum.setForeground(new Color(255,0,0));
		askedBurgerNum.setBounds(400, 20, 500, 100);	
		
	    patty = new JLabel("PATTY");
		patty.setOpaque(false);
		patty.setFont(new Font("�޸����",Font.BOLD,15));
		patty.setHorizontalAlignment(SwingConstants.CENTER);
		patty.setForeground(new Color(0,0,0));
		patty.setBounds(20,0,100,100);  
		
	    pattyNum = new JLabel("0");
		pattyNum .setOpaque(false);
		pattyNum .setFont(new Font("�޸����",Font.BOLD,15));
		pattyNum .setHorizontalAlignment(SwingConstants.CENTER);
		pattyNum .setForeground(new Color(0,0,0));
		pattyNum .setBounds(90,0,100,100);  
		
		vegetables = new JLabel("VEGETABLES");
		vegetables.setOpaque(false);
		vegetables.setFont(new Font("�޸����",Font.BOLD,15));
		vegetables.setHorizontalAlignment(SwingConstants.CENTER);
		vegetables.setForeground(new Color(0,0,0));
		vegetables.setBounds(20,20,100,100);  
		
		vegetablesNum = new JLabel("0");
		vegetablesNum.setOpaque(false);
		vegetablesNum.setFont(new Font("�޸����",Font.BOLD,15));
		vegetablesNum.setHorizontalAlignment(SwingConstants.CENTER);
		vegetablesNum.setForeground(new Color(0,0,0));
		vegetablesNum.setBounds(90,20,100,100);  
	
	    bun = new JLabel("BUN");
		bun.setOpaque(false);
		bun.setFont(new Font("�޸����",Font.BOLD,15));
		bun.setHorizontalAlignment(SwingConstants.CENTER);
		bun.setForeground(new Color(0,0,0));
		bun.setBounds(20,40,100,100);
	
	    bunNum = new JLabel("0");
		bunNum.setOpaque(false);
		bunNum.setFont(new Font("�޸����",Font.BOLD,15));
		bunNum.setHorizontalAlignment(SwingConstants.CENTER);
		bunNum.setForeground(new Color(0,0,0));
		bunNum.setBounds(90,40,100,100);  
		 
	    burger= new JLabel("BURGER");
	    burger.setOpaque(false);
	    burger.setFont(new Font("�޸����",Font.BOLD,15));
	    burger.setHorizontalAlignment(SwingConstants.CENTER);
	    burger.setForeground(new Color(0,0,0));
	    burger.setBounds(20,90,100,100);
					
	    burgerNum = new JLabel("0");
	    burgerNum.setOpaque(false);
	    burgerNum.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerNum.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerNum.setForeground(new Color(0,0,0));
	    burgerNum.setBounds(90,90,100,100);  
	    
	    burgerConsume1= new JLabel("Customer1");
	    burgerConsume1.setOpaque(false);
	    burgerConsume1.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsume1.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsume1.setForeground(new Color(0,0,0));
	    
	    burgerConsumeNum1 = new JLabel("0");
	    burgerConsumeNum1.setOpaque(false);
	    burgerConsumeNum1.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsumeNum1.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsumeNum1.setForeground(new Color(0,0,0));
	    
	    burgerConsume2= new JLabel("Customer2");
	    burgerConsume2.setOpaque(false);
	    burgerConsume2.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsume2.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsume2.setForeground(new Color(0,0,0));
					
	    burgerConsumeNum2 = new JLabel("0");
	    burgerConsumeNum2.setOpaque(false);
	    burgerConsumeNum2.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsumeNum2.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsumeNum2.setForeground(new Color(0,0,0));

	    burgerConsume3= new JLabel("Customer3");
	    burgerConsume3.setOpaque(false);
	    burgerConsume3.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsume3.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsume3.setForeground(new Color(0,0,0));
				
	    burgerConsumeNum3 = new JLabel("0");
	    burgerConsumeNum3.setOpaque(false);
	    burgerConsumeNum3.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsumeNum3.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsumeNum3.setForeground(new Color(0,0,0));
	    
	    burgerConsume4= new JLabel("Customer4");
	    burgerConsume4.setOpaque(false);
	    burgerConsume4.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsume4.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsume4.setForeground(new Color(0,0,0));
					
	    burgerConsumeNum4 = new JLabel("0");
	    burgerConsumeNum4.setOpaque(false);
	    burgerConsumeNum4.setFont(new Font("�޸����",Font.BOLD,15));
	    burgerConsumeNum4.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsumeNum4.setForeground(new Color(0,0,0));


	    level1Text= new JLabel("Level 1");
	    level1Text.setOpaque(false);
	    level1Text.setFont(new Font("�޸����",Font.BOLD,35));
	    level1Text.setHorizontalAlignment(SwingConstants.CENTER);
	    level1Text.setForeground(new Color(0,0,0));
	    level1Text.setBounds(170,10,200,100);  
	        
	    level2Text= new JLabel("Level 2");
	    level2Text.setOpaque(false);
	    level2Text.setFont(new Font("�޸����",Font.BOLD,35));
	    level2Text.setHorizontalAlignment(SwingConstants.CENTER);
	    level2Text.setForeground(new Color(0,0,0));
	    level2Text.setBounds(350,10,200,100);  
	        
	    level3Text= new JLabel("Level 3");
	    level3Text.setOpaque(false);
	    level3Text.setFont(new Font("�޸����",Font.BOLD,35));
	    level3Text.setHorizontalAlignment(SwingConstants.CENTER);
	    level3Text.setForeground(new Color(0,0,0));
	    level3Text.setBounds(530,10,200,100);  


	    consumer1Text= new JLabel("(�մ�1)");
	    consumer1Text.setOpaque(false);
	    consumer1Text.setFont(new Font("�޸����",Font.BOLD,35));
	    consumer1Text.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer1Text.setForeground(new Color(0,0,0));
	    consumer1Text.setBounds(10,100,200,100);  
	    
	    consumer2Text= new JLabel("(�մ�2)");
	    consumer2Text.setOpaque(false);
	    consumer2Text.setFont(new Font("�޸����",Font.BOLD,35));
	    consumer2Text.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer2Text.setForeground(new Color(0,0,0));
	    consumer2Text.setBounds(10,180,200,100);      
	    
	    consumer3Text= new JLabel("(�մ�3)");
	    consumer3Text.setOpaque(false);
	    consumer3Text.setFont(new Font("�޸����",Font.BOLD,35));
	    consumer3Text.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer3Text.setForeground(new Color(0,0,0));
	    consumer3Text.setBounds(10,260,200,100);      
	    
	    consumer4Text= new JLabel("(�մ�4)");
	    consumer4Text.setOpaque(false);
	    consumer4Text.setFont(new Font("�޸����",Font.BOLD,35));
	    consumer4Text.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer4Text.setForeground(new Color(0,0,0));
	    consumer4Text.setBounds(10,340,200,100);  
	    
	    consumer1Level1Result = new JLabel(level1ConsumeNum1+" ����");
	    consumer1Level1Result.setOpaque(false);
	    consumer1Level1Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer1Level1Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer1Level1Result.setForeground(new Color(0,0,0));
	    consumer1Level1Result.setBounds(200,100,150,100);  
	    
	    consumer2Level1Result = new JLabel("0");
	    consumer2Level1Result.setOpaque(false);
	    consumer2Level1Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer2Level1Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer2Level1Result.setForeground(new Color(0,0,0));
	    consumer2Level1Result.setBounds(200,180,150,100);  
	    
	    consumer1Level2Result = new JLabel(level2ConsumeNum1+" ����");
	    consumer1Level2Result.setOpaque(false);
	    consumer1Level2Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer1Level2Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer1Level2Result.setForeground(new Color(0,0,0));
	    consumer1Level2Result.setBounds(380,100,150,100);  
	    
	    consumer2Level2Result = new JLabel("0");
	    consumer2Level2Result.setOpaque(false);
	    consumer2Level2Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer2Level2Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer2Level2Result.setForeground(new Color(0,0,0));
	    consumer2Level2Result.setBounds(380,180,150,100);  
	    
	    consumer3Level2Result = new JLabel("0");
	    consumer3Level2Result.setOpaque(false);
	    consumer3Level2Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer3Level2Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer3Level2Result.setForeground(new Color(0,0,0));
	    consumer3Level2Result.setBounds(380,260,150,100);  
	    
	    consumer1Level3Result = new JLabel("0");
	    consumer1Level3Result.setOpaque(false);
	    consumer1Level3Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer1Level3Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer1Level3Result.setForeground(new Color(0,0,0));
	    consumer1Level3Result.setBounds(560,100,150,100);  
	    
	    consumer2Level3Result = new JLabel("0");
	    consumer2Level3Result.setOpaque(false);
	    consumer2Level3Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer2Level3Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer2Level3Result.setForeground(new Color(0,0,0));
	    consumer2Level3Result.setBounds(560,180,150,100);  
	    
	    consumer3Level3Result = new JLabel("0");
	    consumer3Level3Result.setOpaque(false);
	    consumer3Level3Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer3Level3Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer3Level3Result.setForeground(new Color(0,0,0));
	    consumer3Level3Result.setBounds(560,260,150,100);  
	    
	    consumer4Level3Result = new JLabel("0");
	    consumer4Level3Result.setOpaque(false);
	    consumer4Level3Result.setFont(new Font("�޸����",Font.BOLD,30));
	    consumer4Level3Result.setHorizontalAlignment(SwingConstants.CENTER);
	    consumer4Level3Result.setForeground(new Color(0,0,0));
	    consumer4Level3Result.setBounds(560,340,150,100);  
	    
	    check = new JLabel();
	    check.setOpaque(false);
	    check.setFont(new Font("�޸����",Font.BOLD,15));
	    check.setHorizontalAlignment(SwingConstants.CENTER);
	    check.setForeground(new Color(255,255,255));
	    check.setBounds(0,0,100,100);  
	    
	    Loading = new JLabel("");
		Loading.setOpaque(false);
		Loading.setFont(new Font("�޸����",Font.BOLD,40));
		Loading.setHorizontalAlignment(SwingConstants.CENTER);
		Loading.setForeground(new Color(0,0,0));
		Loading.setBounds(950,750,200,200);   
			
		roadingFrame.add(roadingBackground);
	 	roadingFrame.setBounds(0, 0, 1250, 1000);  
	 	roadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	roadingFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/BurgerImg.png")); // �ĺ��� 
		roadingFrame.setVisible(true);
		roadingFrame.setResizable(false);
		
		for(int i =0;i<2;i++){
			try {
				Loading.setText("Loading");
				roadingBackground.add(Loading);
				roadingFrame.setVisible(true);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Loading.setText("Loading.");
				roadingBackground.add(Loading);
				roadingFrame.setVisible(true);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Loading.setText("Loading..");
				roadingBackground.add(Loading);
				roadingFrame.setVisible(true);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try { 
				Loading.setText("Loading...");
				roadingBackground.add(Loading);
				roadingFrame.setVisible(true);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
 	
		
		roadingFrame.setVisible(false);  // �ε�â �ݱ�

		gameBackground.add(play);	
		gameBackground.add(gameRules);
	    gameFrame.add(gameBackground);	   
	    gameFrame.setBounds(0, 0, 1250, 1000);  
	    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/BurgerImg.png")); // �ĺ��� ��ġ
		gameFrame.setTitle("���Ը��ƿ��� ���Թ��� �����");
		gameFrame.setVisible(true);
		gameFrame.setResizable(false);	
	
	}
	
	public void play() {   // ���� �÷���
		
		gameFrame.setVisible(false);
		
		 levelCount.setText(""+Point.level); 
	
		switch(Point.level) {
		
			case 3:		pattyNum.setText(""+pp.pattyPoint);
								vegetablesNum.setText(""+pp.vegetablesPoint); 	
								bunNum.setText(""+pp.bunPoint); 
								burgerNum.setText(""+pp.produceNum);
								burgerConsumeNum1.setText(""+pp.consumeNum_1); 
								burgerConsumeNum2.setText(""+pp.consumeNum_2); 
								burgerConsumeNum3.setText(""+pp.consumeNum_3); 
								burgerConsumeNum4.setText(""+pp.consumeNum_4); 	
								consume4.setBounds(580, 850, 200, 50);
								gamePlayBackground.add(consume4);
								burgerConsume4.setBounds(20,190,100,100);
							    checkBoard.add(burgerConsume4);
							    burgerConsumeNum4.setBounds(90,190,100,100); 
							    checkBoard.add(burgerConsumeNum4);
							    gamePlayBackground.add(customer4);  // ��������(�մ�4:����3)
								
			case 2:		pattyNum.setText(""+pp.pattyPoint);
								vegetablesNum.setText(""+pp.vegetablesPoint); 	
								bunNum.setText(""+pp.bunPoint); 
								burgerNum.setText(""+pp.produceNum);
								burgerConsumeNum1.setText(""+pp.consumeNum_1); 
								burgerConsumeNum2.setText(""+pp.consumeNum_2); 
								burgerConsumeNum3.setText(""+pp.consumeNum_3); 
								consume3.setBounds(250, 850, 200, 50);
								gamePlayBackground.add(consume3);
								burgerConsume3.setBounds(20,170,100,100); 
								checkBoard.add(burgerConsume3);
								burgerConsumeNum3.setBounds(90,170,100,100);  
								checkBoard.add(burgerConsumeNum3);
								gamePlayBackground.add(customer3);  //  ������(�մ�3:����2) 
								
			case 1: 		pattyNum.setText(""+pp.pattyPoint);
								vegetablesNum.setText(""+pp.vegetablesPoint); 	
								bunNum.setText(""+pp.bunPoint); 
								burgerNum.setText(""+pp.produceNum);
								burgerConsumeNum1.setText(""+pp.consumeNum_1); 
								burgerConsumeNum2.setText(""+pp.consumeNum_2); 
								break;	
		}
		
		checkBoard.add(patty);
		checkBoard.add(pattyNum);
		checkBoard.add(vegetables);
		checkBoard.add(vegetablesNum);
		checkBoard.add(bun);
		checkBoard.add(bunNum);
		checkBoard.add(burger);
		checkBoard.add(burgerNum);
		

		consume2.setBounds(580, 650, 200, 50);	
		gamePlayBackground.add(consume2);
	    burgerConsume2.setBounds(20,150,100,100);  
		checkBoard.add(burgerConsume2);
	    burgerConsumeNum2.setBounds(90,150,100,100); 
	    checkBoard.add(burgerConsumeNum2);	
		gamePlayBackground.add(customer2);  // ����2(�մ�2:����1)
	    
		consume1.setBounds(250, 650, 200, 50);
		gamePlayBackground.add(consume1);
		burgerConsume1.setBounds(20,130,100,100);
		checkBoard.add(burgerConsume1);
	    burgerConsumeNum1.setBounds(90,130,100,100);
		checkBoard.add(burgerConsumeNum1);
		gamePlayBackground.add(customer1);  // ����1(�մ�1:����1)
		
		gamePlayBackground.add(produce);


		board.add(time);
		gamePlayBackground.add(askedLevel);
		gamePlayBackground.add(levelCount);
		gamePlayBackground.add(askedBurgerNum);
		gamePlayBackground.add(pattyImg);  // ��Ƽ 
		gamePlayBackground.add(vegetablesImg);  // ��ä 
		gamePlayBackground.add(bunImg);  // �� 
	    gamePlayBackground.add(pattyButton);
	    gamePlayBackground.add(vegetablesButton);
	    gamePlayBackground.add(bunButton);
		gamePlayBackground.add(board);  // ������
		gamePlayBackground.add(table);  // ��� �غ� ��
		gamePlayBackground.add(spongeBob); // ��������
		gamePlayBackground.add(squidward); // ¡¡��
		gamePlayBackground.add(krabs); // ���Ի���
		gamePlayBackground.add(blackBoard); // ���� �˶� ��
		
		board.add(checkBoard); // ���� ��
		board.add(burgerImg); // �Ի� ����
	    gamePlayBackground.add(board); // üũ��
	    
	    gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setBounds(0, 0, 1250, 1000);  
		gamePlayFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/GaryImg.png")); // �ĺ���
	 	gamePlayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	gamePlayFrame.setVisible(true);
		gamePlayFrame.setResizable(false);

	}

	
	public void rules() { // ���� ����

	rulesPanel.add(rulesOut);

	rulesFrame.add(rulesPanel);
	rulesFrame.setBounds(0, 0, 1250, 1000);  
	rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	rulesFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/BurgerImg.png")); // �ĺ���
	rulesFrame.setVisible(true);
	rulesFrame.setResizable(false);


	}
	
	public void rulesOut() { // ���� ���� â �ݱ�
		
		rulesFrame.setVisible(false);

	}
	
	public void pattyPoint() {
		pp.pattyPoint+=1;

	}
	
	public void pattyPrint() { // ��Ƽ ���

		pattyNum.setText(""+pp.pattyPoint);
		
		check.setText("'��������'�� '��Ƽ'�� �����Ͽ����ϴ�.");
		 
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);

		checkBoard.add(pattyNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	}
	
	public void vegetablesPoint() {

		pp.vegetablesPoint+=1;

	}
	
	public void vegetablesPrint() { //ä�� ���
		
		vegetablesNum.setText(""+pp.vegetablesPoint);	
	
		check.setText("'¡¡��'�� 'ä��'�� �����Ͽ����ϴ�.");
		 
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
		
		checkBoard.add(vegetablesNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	}

	
	public void bunPoint() {

		pp.bunPoint+=1;
	}
	
	public void bunPrint() { // �� ���	
		
		 bunNum.setText(""+pp.bunPoint);
		 
		check.setText("'���Ի���'�� '��'�� �����Ͽ����ϴ�.");
		 
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
		
		checkBoard.add(bunNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	}
	
	public void  produce() {  // �Ի� ���� ����
		
			if(pp.pattyPoint>=1&& pp.vegetablesPoint>=1&&pp.bunPoint>=1) {

				pp.pattyPoint-=1;
				pp.vegetablesPoint-=1;
				pp.bunPoint-=1;
				pp.produceNum+=1;

				pattyNum.setText(""+pp.pattyPoint);
			
				vegetablesNum.setText(""+pp.vegetablesPoint); 
				
				bunNum.setText(""+pp.bunPoint); 
		
				burgerNum.setText(""+pp.produceNum);
	
				check.setText("'������'���� '�Ի����'�� �����Ͽ����ϴ�.");
				
			} else check.setText("'���'�� �����մϴ�.");
		
		checkBoard.add(pattyNum);
		checkBoard.add(vegetablesNum);
		checkBoard.add(bunNum);
		checkBoard.add(burgerNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
		
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	
	}

	
	public void consume1() { // �Ի� ���� �Һ�


			if (pp.produceNum>0) {

				pp.produceNum-=1;
				pp.consumeNum_1+=1;

				burgerNum.setText(""+pp.produceNum);
				burgerConsumeNum1.setText(""+pp.consumeNum_1); 
				
				check.setText("'����(�մ�1)'�� �Ի������ �Ծ���.");
				
			}
		
		checkBoard.add(burgerNum);
		checkBoard.add(burgerConsumeNum1);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
				
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
		
	}

	public void consume2() { // �Ի� ���� �Һ�
		

			if (pp.produceNum>0) {

				pp.produceNum-=1;
				pp.consumeNum_2+=1;
	
				burgerNum.setText(""+pp.produceNum);
				burgerConsumeNum2.setText(""+pp.consumeNum_2); 
				
				check.setText("'����(�մ�2)'�� �Ի������ �Ծ���.");
				
			} else check.setText("'�Ի����'�� �����ϴ�.");



		checkBoard.add(burgerNum);
		checkBoard.add(burgerConsumeNum2);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
				
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	
	}
	
	public void consume3() { // �Ի� ���� �Һ�

		if (pp.produceNum>0) {

			pp.produceNum-=1;
			pp.consumeNum_3+=1;

			burgerNum.setText(""+pp.produceNum);
			burgerConsumeNum3.setText(""+pp.consumeNum_3); 
			
			check.setText("������(�մ�3)'�� �Ի������ �Ծ���.");
			
		} else check.setText("'�Ի����'�� �����ϴ�.");

	
		checkBoard.add(burgerNum);
		checkBoard.add(burgerConsumeNum3);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
				
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
		
		
	}
	
	public void consume4() { // �Ի� ���� �Һ�

		if (pp.produceNum>0) {

			pp.produceNum-=1;
			pp.consumeNum_4+=1;

			burgerNum.setText(""+pp.produceNum);
			burgerConsumeNum4.setText(""+pp.consumeNum_4); 
			
			check.setText("'��������(�մ�4)'�� �Ի������ �Ծ���.");
			
		} else check.setText("'�Ի����'�� �����ϴ�.");

	

		checkBoard.add(burgerNum);
		checkBoard.add(burgerConsumeNum4);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
				
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);

	}

	public void gameOver() { // ����

		gamePlayFrame.setVisible(false);
				
		play.setText("REPLAY");
		play.setBounds(50, 100, 200, 50);
		endingFrame.add(play);
		endingFrame.add(end);
	 	endingFrame.add(failImg);
	 	endingFrame.setTitle("GAMEOVER");
		endingFrame.setBounds(0, 0, 1250, 1000);  
	 	endingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	endingFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/BurgerImg.png")); // �ĺ��� 
		endingFrame.setVisible(true);	
	}
	
	public void clear() { // ����

		
		System.out.println(Point.level);
		Point.level++;
		gamePlayFrame.setVisible(false);

		
		play.setText("NEXTSTAGE");
		play.setBounds(850, 700,250, 50);
		endingFrame.add(play); 

				
		end.setBounds(850, 800,250, 50);
		endingFrame.add(end);
		
		endingFrame.add(successImg);
		endingFrame.setTitle("CLEAR");
		endingFrame.setBounds(0, 0, 1250, 1000);  
		endingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endingFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/BurgerImg.png")); // �ĺ��� 
		endingFrame.setVisible(true);

	}
	
	public void lastClear() {
		System.out.println(Point.level);
		gamePlayFrame.setVisible(false);

		consumer1Level1Result.setText(level1ConsumeNum1+" ����");
		consumer2Level1Result.setText(level1ConsumeNum2+" ����");
		consumer1Level2Result.setText(level2ConsumeNum1+" ����");
		consumer2Level2Result.setText(level2ConsumeNum2+" ����");
		consumer3Level2Result.setText(level2ConsumeNum3+" ����");
		consumer1Level3Result.setText(level3ConsumeNum1+" ����");
		consumer2Level3Result.setText(level3ConsumeNum2+" ����");
		consumer3Level3Result.setText(level3ConsumeNum3+" ����");
		consumer4Level3Result.setText(level3ConsumeNum4+" ����");
		
		ResultBoard.add(level1Text);
		ResultBoard.add(level2Text);
		ResultBoard.add(level3Text);
		ResultBoard.add(consumer1Text);
		ResultBoard.add(consumer2Text);
		ResultBoard.add(consumer3Text);
		ResultBoard.add(consumer4Text);
		ResultBoard.add(consumer1Level1Result);
		ResultBoard.add(consumer2Level1Result);
		ResultBoard.add(consumer1Level2Result);
		ResultBoard.add(consumer2Level2Result);
		ResultBoard.add(consumer3Level2Result);
		ResultBoard.add(consumer1Level3Result);
		ResultBoard.add(consumer2Level3Result);
		ResultBoard.add(consumer3Level3Result);
		ResultBoard.add(consumer4Level3Result);
				 
		lastEndingFrame.add(ResultBoard);
				
		end.setBounds(850, 800,250, 50);

		lastEndingFrame.add(end);
		lastEndingFrame.add(successImg);
		lastEndingFrame.setTitle("GAMEOVER");
		lastEndingFrame.setBounds(0, 0, 1250, 1000);  
		lastEndingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lastEndingFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/BurgerImg.png")); // �ĺ��� 
		lastEndingFrame.setVisible(true);	
	}
	
	public void end( ) {

		for(int level=1; level<4;level++) {
			try {
			dao.deletePoint(level); 
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		endingFrame.setVisible(false);
		
	}
	
	public void insertDB_level() {
		
		if(Point.level==1) {
			level1ConsumeNum1=Point.consumeNum_1;
			level1ConsumeNum2=Point.consumeNum_2;
			level1ConsumeNum3=Point.consumeNum_3;
			level1ConsumeNum4=Point.consumeNum_4;
		} else if(Point.level==2) {
			level2ConsumeNum1=Point.consumeNum_1;
			level2ConsumeNum2=Point.consumeNum_2;
			level2ConsumeNum3=Point.consumeNum_3;
			level2ConsumeNum4=Point.consumeNum_4;
		} else if(Point.level==3) {
			level3ConsumeNum1=Point.consumeNum_1;
			level3ConsumeNum2=Point.consumeNum_2;
			level3ConsumeNum3=Point.consumeNum_3;
			level3ConsumeNum4=Point.consumeNum_4;
		}

		
		Point point = new Point(Point.level, Point.pattyPoint, Point.vegetablesPoint, Point.bunPoint,Point.produceNum,
				Point.consumeNum_1,Point.consumeNum_2,Point.consumeNum_3,Point.consumeNum_4); 

		try {
			dao.insertPoint(point); // �̷��� �ϸ� ������ ������ ���� ��ü ���� �Ϸ� dto(������ ���� ��ü)�� �����̸� ������� ���´� javabeen�̴�.
		} catch(Exception e) {
			System.out.println("�� ���� ����["+e.getMessage()+"]");
		}

	}

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==play&& !isGameStart) {
				// ��ŸƮ ��ư�� �������� 		

				System.out.println(Point.level);
				if(Point.level==1) {

					pp.pattyPoint=0;
					pp.vegetablesPoint=0;
					pp.bunPoint=0;
					pp.produceNum=0;
					pp.consumeNum_1=0;
					pp.consumeNum_2=0;
					pp.consumeNum_3=0;
					pp.consumeNum_4=0;
								
					check.setText("");
					play();		
					
					
					countdown = 20; //���� �ð� �ʱ�ȭ
				    isGameStart = true;   //���� ������ �˸�				

				    timer = new Timer();
				    timer.schedule(new TimerTask() {
				    	
				     @Override
					     public void run() {
						      if (isGameStart) {    
							       
							       countdown--; //1�ʾ� ī��Ʈ
							       
							     /* �ð��� �� �Ǿ��� �� ���� ���� 5���� �Һ� ���� - > clear
							       							�Һ� ���� -> gameOver */
							       
							       if(countdown< 0 && (pp.consumeNum_1<5||pp.consumeNum_2<5))  {
								        timer.cancel();
								        isGameStart = false;
								        gameOver();
							       } else if (countdown<0 && (pp.consumeNum_1>=5&&pp.consumeNum_2>=5)) {
								        timer.cancel();
								        isGameStart = false;
								        insertDB_level();
								        clear();
							       }
							       time.setText("" + countdown);     
						      }
					     }
				    }, 0, 1000);
				    
				} else if(Point.level==2) {
					
					pp.pattyPoint=0;
					pp.vegetablesPoint=0;
					pp.bunPoint=0;
					pp.produceNum=0;
					pp.consumeNum_1=0;
					pp.consumeNum_2=0;
					pp.consumeNum_3=0;
					pp.consumeNum_4=0;
								
					check.setText("");
					play();		
						
				    countdown = 25; //���� �ð� �ʱ�ȭ
				    isGameStart = true;   //���� ������ �˸�				

				    timer = new Timer();
				    	timer.schedule(new TimerTask() {
				    	
				     @Override
					     public void run() {
						      if (isGameStart) {    
							       
							       countdown--; //1�ʾ� ī��Ʈ
							       
							       //�ð��� �� �Ǿ��� �� ���� ���� 5���� �Һ� ���� - > clear
							       						//	�Һ� ���� -> gameOver 				       
							       if(countdown< 0 && (pp.consumeNum_1<5||
							    		   pp.consumeNum_2<5||pp.consumeNum_3<5))  {
								        timer.cancel();
								        isGameStart = false;
								        gameOver();
							       } else if (countdown<0 && (pp.consumeNum_1>=5||
							    		   pp.consumeNum_2>=5||pp.consumeNum_3>=5)) {
								        timer.cancel();
								        isGameStart = false;
								        insertDB_level();
								  		clear();

							       }
							       time.setText("" + countdown);     
						      }
					     }
				    }, 0, 1000);
					
				} else if(Point.level==3){
					
					pp.pattyPoint=0;
					pp.vegetablesPoint=0;
					pp.bunPoint=0;
					pp.produceNum=0;
					pp.consumeNum_1=0;
					pp.consumeNum_2=0;
					pp.consumeNum_3=0;
					pp.consumeNum_4=0;
									
					check.setText("");
					play();
					
				    countdown = 30; //���� �ð� �ʱ�ȭ
				    isGameStart = true;   //���� ������ �˸�				

				    timer = new Timer();
				    	timer.schedule(new TimerTask() {
				    
				     @Override
					     public void run() {
						      if (isGameStart) {    
							       
							       countdown--; //1�ʾ� ī��Ʈ
							       
							       //�ð��� �� �Ǿ��� �� ���� ���� 5���� �Һ� ���� - > clear
							       							//�Һ� ���� -> gameOver 
							       
							       if(countdown< 0 && (pp.consumeNum_1<5||pp.consumeNum_2<5&&
							    		   pp.consumeNum_1<5||pp.consumeNum_1<5))  {
								        timer.cancel();
								        isGameStart = false;
								        gameOver();
							       } else if (countdown<0 && (pp.consumeNum_1>=5&&pp.consumeNum_2>=5&&
							    		   pp.consumeNum_3>=5&&pp.consumeNum_4>=5)) {
								        timer.cancel();
								        isGameStart = false;
								        insertDB_level();
								        lastClear();
								        
							       }
							       time.setText("" + countdown);     
						      }
					     }
				    }, 0, 1000);

				} 
			} else if (e.getSource()==gameRules)  {
				// ���� ����� ������ ��
				rules();
				
			} else if (e.getSource()==rulesOut) {
				// ���� ������� â�ݱ⸦ ������ ��
				rulesOut();
				
			}  else if (e.getSource()==pattyButton) {
				// ��Ƽ ��ư�� ������ ��
				pattyPoint();
				pattyPrint();			
			} else if (e.getSource()==vegetablesButton) {
				// ä�� ��ư�� ������ ��
				vegetablesPoint();		
				vegetablesPrint();				
			} else if (e.getSource()==bunButton) {
				// �� ��ư�� ������ ��
				bunPoint();
				bunPrint();			
			}  else if (e.getSource()==produce) {
				// ���� ��ư�� ������ ��
				produce();
			}  else if (e.getSource()==consume1) {
				// �Һ� ��ư�� ������ ��
				consume1();
			}  else if (e.getSource()==consume2) {
				// �Һ� ��ư�� ������ ��
				consume2();
			}  else if (e.getSource()==consume3) {
				// �Һ� ��ư�� ������ ��
				consume3();
			}  else if (e.getSource()==consume4) {
				// �Һ� ��ư�� ������ ��
				consume4();
			}  else if(e.getSource()==end) {
				end();
			}

		}
		

	}
		

