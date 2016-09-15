
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author David Rogers
 */
public class GamePanel extends AbsGamePanel {

    CardSprite shownCard;
    CardSprite deckCard;
    CardSprite player1Card1;
    CardSprite player1Card2;
    CardSprite player1Card3;
    CardSprite player2Card1;
    CardSprite player2Card2;
    CardSprite player2Card3;
    CardSprite player3Card1;
    CardSprite player3Card2;
    CardSprite player3Card3;
    CardSprite player4Card1;
    CardSprite player4Card2;
    CardSprite player4Card3;
    TokenSprite player1Tokens;
    TokenSprite player2Tokens;
    TokenSprite player3Tokens;
    TokenSprite player4Tokens;
    TextSprite name1;
    TextSprite name2;
    TextSprite name3;
    TextSprite name4;
    TextSprite information;
    Stack<Integer> deck;
    int tempCardNum;
    boolean knock;
    Agent player2;
    Agent player3;
    Agent player4;
    boolean win1;
    boolean win2;
    boolean win3;
    boolean win4;
    int tokenCount1;
    int tokenCount2;
    int tokenCount3;
    int tokenCount4;
    int knockCount;
    boolean player1Gone;
    boolean player2Gone;
    boolean player3Gone;
    boolean pause;
    boolean lost;
    int whoKnocked;
    boolean player2Active;
    boolean player3Active;
    boolean player4Active;
    int inactivePlayers;
    boolean player1Deal;
    boolean player2Deal;
    boolean player3Deal;
    boolean player4Deal;
    int action;
    boolean flipped;

    /** Creates a new instance of GamePanel */
    public GamePanel() {
        super();
        pause = false;
        knock = false;
        player2 = new Agent();
        player3 = new Agent();
        player4 = new Agent();
        win1 = false;
        win2 = false;
        win3 = false;
        win4 = false;
        tokenCount1 = 4;
        tokenCount2 = 4;
        tokenCount3 = 4;
        tokenCount4 = 4;
        lost = true;
        whoKnocked = 0;
        player2Active = true;
        player3Active = true;
        player4Active = true;
        player1Deal = false;
        player2Deal = false;
        player3Deal = false;
        player4Deal = true;
        flipped = false;
        setBackground(Color.GREEN);
        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_S:
                        if (!deckCard.getSelected() && !pause && !player1Gone) {
                            shownCard.setSelected(true);
                            tempCardNum = shownCard.getCardNum();
                        }
                        break;
                    case KeyEvent.VK_F:
                        if (!shownCard.getSelected() && !pause && !player1Gone && !flipped) {
                            deckCard.setSelected(true);
                            tempCardNum = deck.pop();
                            deckCard.setCardNum(tempCardNum);
                            flipped = true;
                        }
                        break;
                    case KeyEvent.VK_E:
                        if (shownCard.getSelected() && player1Card1.getSelected() && !pause && !player1Gone) {
                            shownCard.setCardNum(player1Card1.getCardNum());
                            player1Card1.setCardNum(tempCardNum);
                            shownCard.setSelected(false);
                            if (checkPlayerTotal() == 31) {
                                win1 = true;
                                whoKnocked = 0;
                                changeTokens();
                                setPause(true);
                            }
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        if (shownCard.getSelected() && player1Card2.getSelected() && !pause && !player1Gone) {
                            shownCard.setCardNum(player1Card2.getCardNum());
                            player1Card2.setCardNum(tempCardNum);
                            shownCard.setSelected(false);
                            if (checkPlayerTotal() == 31) {
                                win1 = true;
                                whoKnocked = 0;
                                changeTokens();
                                setPause(true);
                            }
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        if (shownCard.getSelected() && player1Card3.getSelected() && !pause && !player1Gone) {
                            shownCard.setCardNum(player1Card3.getCardNum());
                            player1Card3.setCardNum(tempCardNum);
                            shownCard.setSelected(false);
                            if (checkPlayerTotal() == 31) {
                                win1 = true;
                                whoKnocked = 0;
                                changeTokens();
                                setPause(true);
                            }
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        if (deckCard.getSelected() && player1Card1.getSelected() && !pause && !player1Gone) {
                            shownCard.setCardNum(player1Card1.getCardNum());
                            player1Card1.setCardNum(tempCardNum);
                            deckCard.setSelected(false);
                            deckCard.setCardNum(0);
                            if (checkPlayerTotal() == 31) {
                                win1 = true;
                                whoKnocked = 0;
                                changeTokens();
                                setPause(true);
                            }
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        if (deckCard.getSelected() && player1Card2.getSelected() && !pause && !player1Gone) {
                            shownCard.setCardNum(player1Card2.getCardNum());
                            player1Card2.setCardNum(tempCardNum);
                            deckCard.setSelected(false);
                            deckCard.setCardNum(0);
                            if (checkPlayerTotal() == 31) {
                                win1 = true;
                                whoKnocked = 0;
                                changeTokens();
                                setPause(true);
                            }
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        if (deckCard.getSelected() && player1Card3.getSelected() && !pause && !player1Gone) {
                            shownCard.setCardNum(player1Card3.getCardNum());
                            player1Card3.setCardNum(tempCardNum);
                            deckCard.setSelected(false);
                            deckCard.setCardNum(0);
                            if (checkPlayerTotal() == 31) {
                                win1 = true;
                                whoKnocked = 0;
                                changeTokens();
                                setPause(true);
                            }
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        flipped = false;
                        break;
                    case KeyEvent.VK_D:
                        if (shownCard.getSelected() && !pause && !player1Gone) {
                            shownCard.setSelected(false);
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        if (deckCard.getSelected() && !pause && !player1Gone) {
                            deckCard.setSelected(false);
                            deckCard.setCardNum(0);
                            shownCard.setCardNum(tempCardNum);
                            flipped = false;
                            if (knock) {
                                knockCount++;
                                if (inactivePlayers == 0) {
                                    if (knockCount > 3) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 1) {
                                    if (knockCount > 2) {
                                        checkWin();
                                        setPause(true);
                                    }
                                }
                                if (inactivePlayers == 2) {
                                    checkWin();
                                    setPause(true);
                                }
                            }

                            player1Gone = true;

                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (player1Card1.getSelected() && !pause && !player1Gone) {
                            player1Card1.setSelected(false);
                            player1Card2.setSelected(true);
                            break;
                        }
                        if (player1Card2.getSelected() && !pause && !player1Gone) {
                            player1Card2.setSelected(false);
                            player1Card3.setSelected(true);
                            break;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (player1Card3.getSelected() && !pause && !player1Gone) {
                            player1Card3.setSelected(false);
                            player1Card2.setSelected(true);
                            break;
                        }
                        if (player1Card2.getSelected() && !pause && !player1Gone) {
                            player1Card2.setSelected(false);
                            player1Card1.setSelected(true);
                            break;
                        }
                        break;
                    case KeyEvent.VK_K:
                        if (!pause && !player1Gone) {
                            knock = true;
                            knockCount++;
                            JOptionPane.showMessageDialog(null, "You knocked");
                            whoKnocked = 1;
                            player1Gone = true;
                        }
                        break;
                    case KeyEvent.VK_J:
                        if (knock && !pause && !player1Gone) {
                            whoKnocked = 1;
                            checkWin();
                            setPause(true);
                        }
                        break;
                    case KeyEvent.VK_N:
                        if(player2Active && player3Active && player4Active){
                            if(player1Gone && !player2Gone && !player3Gone && !pause){
                                player2Gone = true;
                                player2Move1();
                                break;
                            }
                            if (player2Gone && !pause) {
                                player3Move1();
                                player2Gone = false;
                                player3Gone = true;
                                break;
                            }
                            if (player3Gone && !pause) {
                                player4Move1();
                                player3Gone = false;
                                player1Gone = false;
                                break;
                            }
                        }
                        if(player2Active && !player3Active && player4Active){
                            if(player1Gone && !player2Gone && !pause){
                                player2Gone = true;
                                player2Move1();
                                break;
                            }
                            if (player2Gone && !pause) {
                                player4Move1();
                                player2Gone = false;
                                player1Gone = false;
                                break;
                            }
                        }
                        if(player2Active && player3Active && !player4Active){
                            if(player1Gone && !player2Gone && !pause){
                                player2Gone = true;
                                player2Move1();
                                break;
                            }
                            if (player2Gone && !pause) {
                                player3Move1();
                                player2Gone = false;
                                player1Gone = false;
                                break;
                            }
                        }
                        if(!player2Active && player3Active && player4Active){
                            if(player1Gone && !player3Gone && !pause){
                                player3Gone = true;
                                player3Move1();
                                break;
                            }
                            if (player3Gone && !pause) {
                                player4Move1();
                                player3Gone = false;
                                player1Gone = false;
                                break;
                            }
                        }
                        if(player2Active && !player3Active && !player4Active){
                            if(player1Gone && !pause){
                                player2Move1();
                                player1Gone = false;
                                break;
                            }
                        }
                        if(!player2Active && player3Active && !player4Active){
                            if(player1Gone && !pause){
                                player3Move1();
                                player1Gone = false;
                                break;
                            }
                        }
                        if(!player2Active && !player3Active && player4Active){
                            if(player1Gone && !pause){
                                player4Move1();
                                player1Gone = false;
                                break;
                            }
                        }
                        break;
                    case KeyEvent.VK_R:
                        if (pause) {
                            pause = false;
                            inactivePlayers = 0;
                            if (tokenCount2 < 1) {
                                player2Active = false;
                                player2Card1.setVisible(false);
                                player2Card2.setVisible(false);
                                player2Card3.setVisible(false);
                                inactivePlayers++;
                            }
                            if (tokenCount3 < 1) {
                                player3Active = false;
                                player3Card1.setVisible(false);
                                player3Card2.setVisible(false);
                                player3Card3.setVisible(false);
                                inactivePlayers++;
                            }
                            if (tokenCount4 < 1) {
                                player4Active = false;
                                player4Card1.setVisible(false);
                                player4Card2.setVisible(false);
                                player4Card3.setVisible(false);
                                inactivePlayers++;
                            }
                            if (inactivePlayers == 3) {
                                lost = false;
                                setGameOver(true);
                            }
                            win1 = false;
                            win2 = false;
                            win3 = false;
                            win4 = false;
                            knock = false;
                            knockCount = 0;
                            whoKnocked = 0;
                            player1Gone = false;
                            player2Gone = false;
                            player3Gone = false;
                            playerDeal();
                            deal();
                            if (inactivePlayers == 0) {
                                if (player1Deal) {
                                    player1Gone = true;
                                }
                                if (player2Deal) {
                                    player1Gone = true;
                                    player2Gone = true;
                                }
                                if (player3Deal) {
                                    player1Gone = true;
                                    player3Gone = true;
                                }
                            }
                            if (inactivePlayers == 1) {
                                if (player1Deal) {
                                    player1Gone = true;
                                }
                                if (player2Deal || player3Deal) {
                                    player1Gone = true;
                                    player2Gone = true;
                                }
                            }
                            if (inactivePlayers == 2) {
                                if (player1Deal) {
                                    player1Gone = true;
                                }
                            }
                            player2Card1.setCardNum(0);
                            player2Card2.setCardNum(0);
                            player2Card3.setCardNum(0);
                            player3Card1.setCardNum(0);
                            player3Card2.setCardNum(0);
                            player3Card3.setCardNum(0);
                            player4Card1.setCardNum(0);
                            player4Card2.setCardNum(0);
                            player4Card3.setCardNum(0);
                            deckCard.setCardNum(0);
                            setTokens();
                            if (tokenCount1 < 1) {
                                lost = true;
                                setGameOver(true);
                            }
                            if (!player2Active && !player3Active && !player4Active) {
                                lost = false;
                                setGameOver(true);
                            }
                        }
                        break;
                    case KeyEvent.VK_H:
                        JFrame frame = new JFrame();
                        frame.setSize(200, 220);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        JTextArea text = new JTextArea();
                        text.setText("Action Keys \n");
                        text.append("s: Select shown card \n");
                        text.append("f: Flip deck card \n");
                        text.append("d: Drop selected card \n");
                        text.append("e: Exchange selected card \n");
                        text.append("k: Knock \n");
                        text.append("j: Double knock \n");
                        text.append("n: Next player goes \n");
                        text.append("r: Next deal \n");
                        text.append("right arrow: Move right \n");
                        text.append("left arrow: Move left \n");
                        text.setEditable(false);
                        frame.add(text);
                    default:
                        ;
                }
            }
        });
    }

    public int playerDeal() {
        if (player1Deal && player2Active) {
            player1Deal = false;
            player2Deal = true;
            return 1;
        }
        if (player1Deal && player3Active) {
            player1Deal = false;
            player3Deal = true;
            return 1;
        }
        if (player1Deal && player4Active) {
            player1Deal = false;
            player4Deal = true;
            return 1;
        }
        if (player2Deal && player3Active) {
            player2Deal = false;
            player3Deal = true;
            return 1;
        }
        if (player2Deal && player4Active) {
            player2Deal = false;
            player4Deal = true;
            return 1;
        }
        if (player2Deal) {
            player2Deal = false;
            player1Deal = true;
            return 1;
        }
        if (player3Deal && player4Active) {
            player3Deal = false;
            player4Deal = true;
            return 1;
        }
        if (player3Deal) {
            player3Deal = false;
            player1Deal = true;
            return 1;
        }
        if (player4Deal) {
            player4Deal = false;
            player1Deal = true;
            return 1;
        }
        return 0;
    }

    public void setTokens() {
        player1Tokens.setTokens(tokenCount1);
        player2Tokens.setTokens(tokenCount2);
        player3Tokens.setTokens(tokenCount3);
        player4Tokens.setTokens(tokenCount4);
    }

    public void changeTokens() {
        if (!win1) {
            tokenCount1--;
            if (whoKnocked == 1) {
                tokenCount1--;
            }
        }
        if (!win2) {
            tokenCount2--;
            if (whoKnocked == 2) {
                tokenCount2--;
            }
        }
        if (!win3) {
            tokenCount3--;
            if (whoKnocked == 3) {
                tokenCount3--;
            }
        }
        if (!win4) {
            tokenCount4--;
            if (whoKnocked == 4) {
                tokenCount4--;
            }
        }
    }

    public int checkPlayerTotal() {
        int spades = 0;
        int hearts = 0;
        int diamonds = 0;
        int clubs = 0;

        if (player2.determineSuit(player1Card1.getCardNum()) == 's') {
            spades += player2.determineValue(player1Card1.getCardNum());
        }
        if (player2.determineSuit(player1Card1.getCardNum()) == 'h') {
            hearts += player2.determineValue(player1Card1.getCardNum());
        }
        if (player2.determineSuit(player1Card1.getCardNum()) == 'd') {
            diamonds += player2.determineValue(player1Card1.getCardNum());
        }
        if (player2.determineSuit(player1Card1.getCardNum()) == 'c') {
            clubs += player2.determineValue(player1Card1.getCardNum());
        }

        if (player2.determineSuit(player1Card2.getCardNum()) == 's') {
            spades += player2.determineValue(player1Card2.getCardNum());
        }
        if (player2.determineSuit(player1Card2.getCardNum()) == 'h') {
            hearts += player2.determineValue(player1Card2.getCardNum());
        }
        if (player2.determineSuit(player1Card2.getCardNum()) == 'd') {
            diamonds += player2.determineValue(player1Card2.getCardNum());
        }
        if (player2.determineSuit(player1Card2.getCardNum()) == 'c') {
            clubs += player2.determineValue(player1Card2.getCardNum());
        }

        if (player2.determineSuit(player1Card3.getCardNum()) == 's') {
            spades += player2.determineValue(player1Card3.getCardNum());
        }
        if (player2.determineSuit(player1Card3.getCardNum()) == 'h') {
            hearts += player2.determineValue(player1Card3.getCardNum());
        }
        if (player2.determineSuit(player1Card3.getCardNum()) == 'd') {
            diamonds += player2.determineValue(player1Card3.getCardNum());
        }
        if (player2.determineSuit(player1Card3.getCardNum()) == 'c') {
            clubs += player2.determineValue(player1Card3.getCardNum());
        }

        if (spades >= hearts && spades >= diamonds && spades >= clubs) {
            return spades;
        }
        if (hearts >= spades && hearts >= diamonds && hearts >= clubs) {
            return hearts;
        }
        if (diamonds >= spades && diamonds >= hearts && diamonds >= clubs) {
            return diamonds;
        }
        if (clubs >= spades && clubs >= hearts && clubs >= diamonds) {
            return clubs;
        }
        return -1;
    }

    public void checkWin() {
        int player1Total = checkPlayerTotal();
        int player2Total = player2.getTotal();
        int player3Total = player3.getTotal();
        int player4Total = player4.getTotal();
        if (inactivePlayers == 0) {
            if (player1Total > player2Total || player1Total
                    > player3Total || player1Total > player4Total) {
                win1 = true;
            }
            if (player2Total > player1Total || player2Total
                    > player3Total || player2Total > player4Total) {
                win2 = true;
            }
            if (player3Total > player1Total || player3Total
                    > player2Total || player3Total > player4Total) {
                win3 = true;
            }
            if (player4Total > player1Total || player4Total
                    > player2Total || player4Total > player3Total) {
                win4 = true;
            }
        }
        if (player2Active && player3Active && !player4Active) {
            if (player1Total > player2Total || player1Total > player3Total) {
                win1 = true;
            }
            if (player2Total > player1Total || player2Total > player3Total) {
                win2 = true;
            }
            if (player3Total > player1Total || player3Total > player2Total) {
                win3 = true;
            }
        }
        if (player2Active && !player3Active && player4Active) {
            if (player1Total > player2Total || player1Total > player4Total) {
                win1 = true;
            }
            if (player2Total > player1Total || player2Total > player4Total) {
                win2 = true;
            }
            if (player4Total > player1Total || player4Total > player2Total) {
                win4 = true;
            }
        }
        if (!player2Active && player3Active && player4Active) {
            if (player1Total > player3Total || player1Total > player4Total) {
                win1 = true;
            }
            if (player3Total > player1Total || player3Total > player4Total) {
                win3 = true;
            }
            if (player4Total > player1Total || player4Total > player3Total) {
                win4 = true;
            }
        }
        if (player2Active && !player3Active && !player4Active) {
            if (player1Total > player2Total) {
                win1 = true;
            }
            if (player2Total > player1Total) {
                win2 = true;
            }
        }
        if (!player2Active && player3Active && !player4Active) {
            if (player1Total > player3Total) {
                win1 = true;
            }
            if (player3Total > player1Total) {
                win3 = true;
            }
        }
        if (!player2Active && !player3Active && player4Active) {
            if (player1Total > player4Total) {
                win1 = true;
            }
            if (player4Total > player1Total) {
                win4 = true;
            }
        }
        changeTokens();
    }

    public int player2Move1() {
        if (deck.empty()) {
            checkWin();
            setPause(true);
            return 0;
        }
        if (player2.getTotal() == 31) {
            win2 = true;
            whoKnocked = 0;
            changeTokens();
            setPause(true);
            return 0;
        }
        action = player2.determineAction1(shownCard.getCardNum(), knock);
        if (action < 4) {
            MoveLeft left = new MoveLeft();
            shownCard.initMotion(left);
        }
        if (action == 4) {
            action = player2.determineAction2(deck.peek());
            if (action < 8) {
                MoveLeft left = new MoveLeft();
                deckCard.initMotion(left);
            }
        }
        if (action > 7) {
            playerAction(2);
        }
        return action;
    }

    public int player2Move2() {

        playerAction(2);

        if (knock) {
            knockCount++;
            if (inactivePlayers == 0) {
                if (knockCount > 3) {
                    checkWin();
                    setPause(true);
                }
            }
            if (inactivePlayers == 1) {
                if (knockCount > 2) {
                    checkWin();
                    setPause(true);
                }
            }
            if (inactivePlayers == 2) {
                checkWin();
                setPause(true);
            }
        }
        //showAllCards();
        return 1;
    }

    public int player3Move1() {
        if (deck.empty()) {
            checkWin();
            setPause(true);
            return 0;
        }
        if (player3.getTotal() == 31) {
            win3 = true;
            whoKnocked = 0;
            changeTokens();
            setPause(true);
            return 0;
        }
        action = player3.determineAction1(shownCard.getCardNum(), knock);
        if (action < 4) {
            MoveUp up = new MoveUp();
            shownCard.initMotion(up);
        }
        if (action == 4) {
            action = player3.determineAction2(deck.peek());
            if (action < 8) {
                MoveUp up = new MoveUp();
                deckCard.initMotion(up);
            }
        }
        if (action > 7) {
            playerAction(3);
        }
        return action;
    }

    public int player3Move2() {
        playerAction(3);

        if (knock) {
            knockCount++;
            if (inactivePlayers == 0) {
                if (knockCount > 3) {
                    checkWin();
                    setPause(true);
                }
            }
            if (inactivePlayers == 1) {
                if (knockCount > 2) {
                    checkWin();
                    setPause(true);
                }
            }
            if (inactivePlayers == 2) {
                checkWin();
                setPause(true);
            }
        }
        //showAllCards();
        return 1;
    }

    public int player4Move1() {
        if (deck.empty()) {
            checkWin();
            setPause(true);
            return 0;
        }
        if (player4.getTotal() == 31) {
            win4 = true;
            whoKnocked = 0;
            changeTokens();
            setPause(true);
            return 0;
        }
        action = player4.determineAction1(shownCard.getCardNum(), knock);
        if (action < 4) {
            MoveRight right = new MoveRight();
            shownCard.initMotion(right);
        }
        if (action == 4) {
            action = player4.determineAction2(deck.peek());
            if (action < 8) {
                MoveRight right = new MoveRight();
                deckCard.initMotion(right);
            }
        }
        if (action > 7) {
            playerAction(4);
        }
        return action;
    }

    public int player4Move2() {
        playerAction(4);

        if (knock) {
            knockCount++;
            if (inactivePlayers == 0) {
                if (knockCount > 3) {
                    checkWin();
                    setPause(true);
                }
            }
            if (inactivePlayers == 1) {
                if (knockCount > 2) {
                    checkWin();
                    setPause(true);
                }
            }
            if (inactivePlayers == 2) {
                checkWin();
                setPause(true);
            }
        }
        //showAllCards();
        return 1;
    }

    public void playerAction(int player) {
        if (action == 1 && player == 2) {
            int temp = player2.getCard1();
            player2.setCard1(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player2.setCardValues();
            if (player2.getTotal() == 31) {
                win2 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 1 && player == 3) {
            int temp = player3.getCard1();
            player3.setCard1(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player3.setCardValues();
            if (player3.getTotal() == 31) {
                win3 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 1 && player == 4) {
            int temp = player4.getCard1();
            player4.setCard1(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player4.setCardValues();
            if (player4.getTotal() == 31) {
                win4 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 2 && player == 2) {
            int temp = player2.getCard2();
            player2.setCard2(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player2.setCardValues();
            if (player2.getTotal() == 31) {
                win2 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 2 && player == 3) {
            int temp = player3.getCard2();
            player3.setCard2(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player3.setCardValues();
            if (player3.getTotal() == 31) {
                win3 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 2 && player == 4) {
            int temp = player4.getCard2();
            player4.setCard2(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player4.setCardValues();
            if (player4.getTotal() == 31) {
                win4 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 3 && player == 2) {
            int temp = player2.getCard3();
            player2.setCard3(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player2.setCardValues();
            if (player2.getTotal() == 31) {
                win2 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 3 && player == 3) {
            int temp = player3.getCard3();
            player3.setCard3(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player3.setCardValues();
            if (player3.getTotal() == 31) {
                win3 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 3 && player == 4) {
            int temp = player4.getCard3();
            player4.setCard3(shownCard.getCardNum());
            shownCard.setCardNum(temp);
            player4.setCardValues();
            if (player4.getTotal() == 31) {
                win4 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 4 && player == 2) {
            int temp = player2.getCard1();
            player2.setCard1(deck.pop());
            shownCard.setCardNum(temp);
            player2.setCardValues();
            if (player2.getTotal() == 31) {
                win2 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 4 && player == 3) {
            int temp = player3.getCard1();
            player3.setCard1(deck.pop());
            shownCard.setCardNum(temp);
            player3.setCardValues();
            if (player3.getTotal() == 31) {
                win3 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 4 && player == 4) {
            int temp = player4.getCard1();
            player4.setCard1(deck.pop());
            shownCard.setCardNum(temp);
            player4.setCardValues();
            if (player4.getTotal() == 31) {
                win4 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 5 && player == 2) {
            int temp = player2.getCard2();
            player2.setCard2(deck.pop());
            shownCard.setCardNum(temp);
            player2.setCardValues();
            if (player2.getTotal() == 31) {
                win2 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 5 && player == 3) {
            int temp = player3.getCard2();
            player3.setCard2(deck.pop());
            shownCard.setCardNum(temp);
            player3.setCardValues();
            if (player3.getTotal() == 31) {
                win3 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 5 && player == 4) {
            int temp = player4.getCard2();
            player4.setCard2(deck.pop());
            shownCard.setCardNum(temp);
            player4.setCardValues();
            if (player4.getTotal() == 31) {
                win4 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 6 && player == 2) {
            int temp = player2.getCard3();
            player2.setCard3(deck.pop());
            shownCard.setCardNum(temp);
            player2.setCardValues();
            if (player2.getTotal() == 31) {
                win2 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 6 && player == 3) {
            int temp = player3.getCard3();
            player3.setCard3(deck.pop());
            shownCard.setCardNum(temp);
            player3.setCardValues();
            if (player3.getTotal() == 31) {
                win3 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 6 && player == 4) {
            int temp = player4.getCard3();
            player4.setCard3(deck.pop());
            shownCard.setCardNum(temp);
            player4.setCardValues();
            if (player4.getTotal() == 31) {
                win4 = true;
                whoKnocked = 0;
                changeTokens();
                setPause(true);
            }
        }
        if (action == 7) {
            shownCard.setCardNum(deck.pop());
        }
        if (action == 8 && player == 2) {
            knock = true;
            knockCount++;
            whoKnocked = 2;
            JOptionPane.showMessageDialog(this, "Player 2 knocked");
        }
        if (action == 8 && player == 3) {
            whoKnocked = 3;
            knockCount++;
            knock = true;
            JOptionPane.showMessageDialog(this, "Player 3 knocked");
        }
        if (action == 8 && player == 4) {
            whoKnocked = 4;
            knockCount++;
            knock = true;
            JOptionPane.showMessageDialog(this, "Player 4 knocked");
        }
        if (action == 9 && player == 2) {
            JOptionPane.showMessageDialog(this, "Player" + 2 + " double knocked");
            whoKnocked = 2;
            checkWin();
            setPause(true);
        }
        if (action == 9 && player == 3) {
            JOptionPane.showMessageDialog(this, "Player" + 3 + " double knocked");
            whoKnocked = 3;
            checkWin();
            setPause(true);
        }
        if (action == 9 && player == 4) {
            JOptionPane.showMessageDialog(this, "Player" + 4 + " double knocked");
            whoKnocked = 4;
            checkWin();
            setPause(true);
        }

    }

    public void deal() {
        deck = shuffle();

        if (player2Active && player3Active && player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player2.setCard1(deck.pop());
                player3.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player3.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());

            }
            if (player2Deal) {
                JOptionPane.showMessageDialog(this, "Player2 delt");
                player3.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player3Deal) {
                JOptionPane.showMessageDialog(this, "Player3 delt");
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player3.setCard1(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player3.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player4Deal) {
                JOptionPane.showMessageDialog(this, "Player4 delt");
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player3.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player3.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
                //player4.setCard1(4);
                //player4.setCard2(2);
                //player4.setCard3(3);
                //player1Card1.setCardNum(3);
                //player1Card2.setCardNum(2);
                //player1Card3.setCardNum(25);
                //shownCard.setCardNum(1);
            }
        }
        if (player2Active && player3Active && !player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player2.setCard1(deck.pop());
                player3.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player3.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player2Deal) {
                JOptionPane.showMessageDialog(this, "Player2 delt");
                player3.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player3.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player3Deal) {
                JOptionPane.showMessageDialog(this, "Player3 delt");
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player3.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player3.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player3.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
        }

        if (player2Active && !player3Active && player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player2.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player2Deal) {
                JOptionPane.showMessageDialog(this, "Player2 delt");
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player4Deal) {
                JOptionPane.showMessageDialog(this, "Player4 delt");
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
        }

        if (!player2Active && player3Active && player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player3.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player3.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player3Deal) {
                JOptionPane.showMessageDialog(this, "Player3 delt");
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player3.setCard1(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player3.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player4Deal) {
                JOptionPane.showMessageDialog(this, "Player4 delt");
                player1Card1.setCardNum(deck.pop());
                player3.setCard1(deck.pop());
                player4.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player3.setCard2(deck.pop());
                player4.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player3.setCard3(deck.pop());
                player4.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }

        }

        if (player2Active && !player3Active && !player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player2.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player2Deal) {
                JOptionPane.showMessageDialog(this, "Player2 delt");
                player1Card1.setCardNum(deck.pop());
                player2.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player2.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player2.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
        }

        if (!player2Active && !player3Active && player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player4.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player4.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player4.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player4Deal) {
                JOptionPane.showMessageDialog(this, "Player4 delt");
                player1Card1.setCardNum(deck.pop());
                player4.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player4.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player4.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
        }

        if (!player2Active && player3Active && !player4Active) {
            if (player1Deal) {
                JOptionPane.showMessageDialog(this, "You delt");
                player3.setCard1(deck.pop());
                player1Card1.setCardNum(deck.pop());
                player3.setCard2(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player3.setCard3(deck.pop());
                player1Card3.setCardNum(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
            if (player3Deal) {
                JOptionPane.showMessageDialog(this, "Player3 delt");
                player1Card1.setCardNum(deck.pop());
                player3.setCard1(deck.pop());
                player1Card2.setCardNum(deck.pop());
                player3.setCard2(deck.pop());
                player1Card3.setCardNum(deck.pop());
                player3.setCard3(deck.pop());
                shownCard.setCardNum(deck.pop());
            }
        }

        player2.setCardValues();
        player3.setCardValues();
        player4.setCardValues();
        player2.findGetSuit();
        player3.findGetSuit();
        player4.findGetSuit();
        //showAllCards();
    }

    public void initSprites() {
        MoveStop stop = new MoveStop();
        player2Card1 = new CardSprite();
        player2Card1.setLocx(Consts.PLAYER2X);
        player2Card1.setLocy(Consts.PLAYER2YCARD1);
        player2Card1.setCardNum(0);
        player2Card1.initMotion(stop);
        player2Card1.initCardImages();
        getSpriteAry().add(player2Card1);

        player2Card2 = new CardSprite();
        player2Card2.initMotion(stop);
        player2Card2.initCardImages();
        player2Card2.setLocx(Consts.PLAYER2X);
        player2Card2.setLocy(Consts.PLAYER2YCARD2);
        player2Card2.setCardNum(0);
        getSpriteAry().add(player2Card2);

        player2Card3 = new CardSprite();
        player2Card3.initMotion(stop);
        player2Card3.initCardImages();
        player2Card3.setLocx(Consts.PLAYER2X);
        player2Card3.setLocy(Consts.PLAYER2YCARD3);
        player2Card3.setCardNum(0);
        getSpriteAry().add(player2Card3);

        player2Tokens = new TokenSprite();
        player2Tokens.setLocx(Consts.PLAYER2X);
        player2Tokens.setLocy(Consts.PLAYER2TOKENS);
        player2Tokens.setColor(Color.YELLOW);
        getSpriteAry().add(player2Tokens);

        name2 = new TextSprite();
        name2.setName("Player2");
        name2.setLocx(Consts.PLAYER2X);
        name2.setLocy(Consts.PLAYER2YCARD1 - 35);
        name2.setColor(Color.BLACK);
        getSpriteAry().add(name2);

        player1Card1 = new CardSprite();
        player1Card1.initMotion(stop);
        player1Card1.initCardImages();
        player1Card1.setLocx(Consts.PLAYER1XCARD1);
        player1Card1.setLocy(Consts.PLAYER1Y);
        player1Card1.setSelected(true);
        player1Card1.setCardNum(0);
        getSpriteAry().add(player1Card1);

        player1Card2 = new CardSprite();
        player1Card2.initMotion(stop);
        player1Card2.initCardImages();
        player1Card2.setLocx(Consts.PLAYER1XCARD2);
        player1Card2.setLocy(Consts.PLAYER1Y);
        player1Card2.setCardNum(0);
        getSpriteAry().add(player1Card2);

        player1Card3 = new CardSprite();
        player1Card3.initMotion(stop);
        player1Card3.initCardImages();
        player1Card3.setLocx(Consts.PLAYER1XCARD3);
        player1Card3.setLocy(Consts.PLAYER1Y);
        player1Card3.setCardNum(0);
        getSpriteAry().add(player1Card3);

        player1Tokens = new TokenSprite();
        player1Tokens.setLocx(Consts.PLAYER1XCARD1);
        player1Tokens.setLocy(Consts.PLAYER1TOKENS);
        player1Tokens.setColor(Color.YELLOW);
        getSpriteAry().add(player1Tokens);

        name1 = new TextSprite();
        name1.setName("Player1");
        name1.setLocx(Consts.PLAYER1XCARD1 + 100);
        name1.setLocy(Consts.PLAYER1TOKENS + 15);
        name1.setColor(Color.BLACK);
        getSpriteAry().add(name1);

        player3Card1 = new CardSprite();
        player3Card1.initMotion(stop);
        player3Card1.initCardImages();
        player3Card1.setLocx(Consts.PLAYER3XCARD1);
        player3Card1.setLocy(Consts.PLAYER3Y);
        player3Card1.setCardNum(0);
        getSpriteAry().add(player3Card1);

        player3Card2 = new CardSprite();
        player3Card2.initMotion(stop);
        player3Card2.initCardImages();
        player3Card2.setLocx(Consts.PLAYER3XCARD2);
        player3Card2.setLocy(Consts.PLAYER3Y);
        player3Card2.setCardNum(0);
        getSpriteAry().add(player3Card2);

        player3Card3 = new CardSprite();
        player3Card3.initMotion(stop);
        player3Card3.initCardImages();
        player3Card3.setLocx(Consts.PLAYER3XCARD3);
        player3Card3.setLocy(Consts.PLAYER3Y);
        player3Card3.setCardNum(0);
        getSpriteAry().add(player3Card3);

        player3Tokens = new TokenSprite();
        player3Tokens.setLocx(Consts.PLAYER3XCARD1);
        player3Tokens.setLocy(Consts.PLAYER3TOKENS);
        player3Tokens.setColor(Color.YELLOW);
        getSpriteAry().add(player3Tokens);

        name3 = new TextSprite();
        name3.setName("Player3");
        name3.setLocx(Consts.PLAYER3XCARD1 + 100);
        name3.setLocy(Consts.PLAYER3TOKENS + 15);
        name3.setColor(Color.BLACK);
        getSpriteAry().add(name3);

        player4Card1 = new CardSprite();
        player4Card1.initMotion(stop);
        player4Card1.initCardImages();
        player4Card1.setLocx(Consts.PLAYER4X);
        player4Card1.setLocy(Consts.PLAYER4YCARD1);
        player4Card1.setCardNum(0);
        getSpriteAry().add(player4Card1);

        player4Card2 = new CardSprite();
        player4Card2.initMotion(stop);
        player4Card2.initCardImages();
        player4Card2.setLocx(Consts.PLAYER4X);
        player4Card2.setLocy(Consts.PLAYER4YCARD2);
        player4Card2.setCardNum(0);
        getSpriteAry().add(player4Card2);

        player4Card3 = new CardSprite();
        player4Card3.initMotion(stop);
        player4Card3.initCardImages();
        player4Card3.setLocx(Consts.PLAYER4X);
        player4Card3.setLocy(Consts.PLAYER4YCARD3);
        player4Card3.setCardNum(0);
        getSpriteAry().add(player4Card3);

        player4Tokens = new TokenSprite();
        player4Tokens.setLocx(Consts.PLAYER4X);
        player4Tokens.setLocy(Consts.PLAYER4TOKENS);
        player4Tokens.setColor(Color.YELLOW);
        getSpriteAry().add(player4Tokens);

        name4 = new TextSprite();
        name4.setName("Player4");
        name4.setLocx(Consts.PLAYER4X);
        name4.setLocy(Consts.PLAYER4YCARD1 - 35);
        name4.setColor(Color.BLACK);
        getSpriteAry().add(name4);

        shownCard = new CardSprite();
        shownCard.initMotion(stop);
        shownCard.initCardImages();
        shownCard.setLocx(Consts.SHOWNCARDX);
        shownCard.setLocy(Consts.SHOWNCARDY);
        shownCard.setCardNum(0);
        shownCard.addPropertyChangeListener(new CardListener());
        getSpriteAry().add(shownCard);

        deckCard = new CardSprite();
        deckCard.initMotion(stop);
        deckCard.initCardImages();
        deckCard.setLocx(Consts.DECKCARDX);
        deckCard.setLocy(Consts.DECKCARDY);
        deckCard.setCardNum(0);
        deckCard.addPropertyChangeListener(new CardListener());
        getSpriteAry().add(deckCard);

        information = new TextSprite();
        information.setName("Press h for help");
        information.setLocx(Consts.SHOWNCARDX + 35);
        information.setLocy(Consts.SHOWNCARDY + 130);
        information.setColor(Color.BLACK);
        getSpriteAry().add(information);
    }

    public Stack<Integer> shuffle() {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
                28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
                44, 45, 46, 47, 48, 49, 50, 51, 52);
        Collections.shuffle(list);
        for (int i = 0; i < 52; i++) {
            stack.push(list.get(i));
        }
        return stack;
    }

    public void showAllCards() {
        player2Card1.setCardNum(player2.getCard1());
        player2Card2.setCardNum(player2.getCard2());
        player2Card3.setCardNum(player2.getCard3());
        player3Card1.setCardNum(player3.getCard1());
        player3Card2.setCardNum(player3.getCard2());
        player3Card3.setCardNum(player3.getCard3());
        player4Card1.setCardNum(player4.getCard1());
        player4Card2.setCardNum(player4.getCard2());
        player4Card3.setCardNum(player4.getCard3());
        deckCard.setCardNum(deck.peek());
        repaint();
    }

    public void pauseAnnouncement(Graphics2D g2d) {
        if (pause) {
            showAllCards();
            if (!win1) {
                Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                g2d.setFont(myFont);
                g2d.setColor(Color.red);
                g2d.drawString("You lose, score = " + checkPlayerTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION1Y);
            }
            if (win1) {
                Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                g2d.setFont(myFont);
                g2d.setColor(Color.red);
                g2d.drawString("You Win! score = " + checkPlayerTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION1Y);
            }
            if (player2Active) {
                if (!win2) {
                    Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                    g2d.setFont(myFont);
                    g2d.setColor(Color.red);
                    g2d.drawString("Player2 loses, score = " + player2.getTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION2Y);
                }
                if (win2) {
                    Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                    g2d.setFont(myFont);
                    g2d.setColor(Color.red);
                    g2d.drawString("Player2 wins, score = " + player2.getTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION2Y);
                }
            }
            if (player3Active) {
                if (!win3) {
                    Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                    g2d.setFont(myFont);
                    g2d.setColor(Color.red);
                    g2d.drawString("Player3 loses, score = " + player3.getTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION3Y);
                }
                if (win3) {
                    Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                    g2d.setFont(myFont);
                    g2d.setColor(Color.red);
                    g2d.drawString("Player3 wins, score = " + player3.getTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION3Y);
                }
            }
            if (player4Active) {
                if (!win4) {
                    Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                    g2d.setFont(myFont);
                    g2d.setColor(Color.red);
                    g2d.drawString("Player4 loses, score = " + player4.getTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION4Y);
                }
                if (win4) {
                    Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
                    g2d.setFont(myFont);
                    g2d.setColor(Color.red);
                    g2d.drawString("Player4 wins, score = " + player4.getTotal(), Consts.TEXTPOSITIONX, Consts.TEXTPOSITION4Y);
                }
            }

        }
    }

    public void announceTermination(Graphics2D g2d) {
        if (lost) {
            Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
            g2d.setFont(myFont);
            g2d.setColor(Color.red);
            g2d.drawString("You Lost :(", Consts.TEXTPOSITIONX, Consts.TEXTPOSITION1Y);
        }
        if (!lost) {
            Font myFont = new Font("Courier", Font.BOLD, Consts.FONTSIZE);
            g2d.setFont(myFont);
            g2d.setColor(Color.red);
            g2d.drawString("You Win :)", Consts.TEXTPOSITIONX, Consts.TEXTPOSITION1Y);
        }
    }

    class CardListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("player2Move")) {
                MoveStop stop = new MoveStop();
                shownCard.initMotion(stop);
                deckCard.initMotion(stop);
                shownCard.setLocx(Consts.SHOWNCARDX);
                shownCard.setLocy(Consts.SHOWNCARDY);
                deckCard.setLocx(Consts.DECKCARDX);
                deckCard.setLocy(Consts.DECKCARDY);
                player2Move2();
            }
            if (evt.getPropertyName().equals("player3Move")) {
                MoveStop stop = new MoveStop();
                shownCard.initMotion(stop);
                deckCard.initMotion(stop);
                shownCard.setLocx(Consts.SHOWNCARDX);
                shownCard.setLocy(Consts.SHOWNCARDY);
                deckCard.setLocx(Consts.DECKCARDX);
                deckCard.setLocy(Consts.DECKCARDY);
                player3Move2();
            }
            if (evt.getPropertyName().equals("player4Move")) {
                MoveStop stop = new MoveStop();
                shownCard.initMotion(stop);
                deckCard.initMotion(stop);
                shownCard.setLocx(Consts.SHOWNCARDX);
                shownCard.setLocy(Consts.SHOWNCARDY);
                deckCard.setLocx(Consts.DECKCARDX);
                deckCard.setLocy(Consts.DECKCARDY);
                player4Move2();
            }

        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public void setWin1(boolean win) {
        win1 = win;
    }

    public boolean getWin1() {
        return win1;
    }
}
