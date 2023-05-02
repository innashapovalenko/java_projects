import org.junit.*;
import static org.junit.Assert.assertEquals;


public class TestBubbles{

    private int[][] board8x8 = {{2,6,1,3,4,8,4,6},
    {0,3,2,9,8,4,2,1},
    {1,2,1,0,1,6,5,8},
    {3,9,6,2,1,1,1,2},
    {0,3,1,2,4,4,3,1},
    {1,3,2,1,1,1,3,6},
    {4,9,9,9,9,9,9,4},
    {9,8,7,6,5,4,3,2}};//rows 0-7, cols 0-7
    private int[][] board4x4 = {{2,6,1,3},
    {0,3,2,9},
    {1,2,1,0},
    {3,9,6,2}};//rows 0-3, cols 0-3
    private int[][] board8x3 = {{3,4,8},
    {0,3,2},
    {6,5,8},
    {9,6,2},
    {2,3,1},
    {1,1,1},
    {9,9,9},
    {9,8,7}};//rows 0-7, cols 0-2
    private int[][] board64x16={{2,6,1,3,4,8,4,6,0,3,2,9,8,4,2,1},
    {3,9,6,2,4,9,9,9,9,9,9,4,1,1,1,2},
    {1,3,6,3,9,6,2,2,9,8,4,4,9,9,6,8},
    {2,6,1,3,4,8,1,2,4,4,3,3,9,6,2,1},
    {3,1,2,4,4,3,1,0,1,6,5,8,6,1,3,4},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {3,1,2,4,4,3,1,1,3,2,1,1,1,1,1,1},
    {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
    {2,2,9,8,7,6,5,4,3,7,7,8,8,4,2,3},
    {4,3,1,7,3,4,2,8,5,9,4,3,3,2,1,0},
    {6,4,2,7,4,9,1,5,2,9,7,0,4,2,6,2},
    {5,3,7,2,8,1,9,2,4,3,9,9,9,7,6,0},
    {3,9,6,2,3,9,6,2,3,9,6,2,3,9,6,2},
    {2,9,8,4,2,4,2,6,3,8,8,7,6,9,1,1},
    {2,6,3,8,0,6,4,0,3,6,1,7,4,5,2,6},
    {2,6,1,3,4,8,4,6,0,3,2,9,8,4,2,1},
    {3,9,6,2,4,9,9,9,9,9,9,4,1,1,1,2},
    {1,3,6,3,9,6,2,2,9,8,4,4,9,9,6,8},
    {2,6,1,3,4,8,1,2,4,4,3,3,9,6,2,1},
    {3,1,2,4,4,3,1,0,1,6,5,8,6,1,3,4},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {3,1,2,4,4,3,1,1,3,2,1,1,1,1,1,1},
    {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
    {2,2,9,8,7,6,5,4,3,7,7,8,8,4,2,3},
    {4,3,1,7,3,4,2,8,5,9,4,3,3,2,1,0},
    {6,4,2,7,4,9,1,5,2,9,7,0,4,2,6,2},
    {5,3,7,2,8,1,9,2,4,3,9,9,9,7,6,0},
    {3,9,6,2,3,9,6,2,3,9,6,2,3,9,6,2},
    {2,9,8,4,2,4,2,6,3,8,8,7,6,9,1,1},
    {2,6,3,8,0,6,4,0,3,6,1,7,4,5,2,6},
    {2,6,1,3,4,8,4,6,0,3,2,9,8,4,2,1},
    {3,9,6,2,4,9,9,9,9,9,9,4,1,1,1,2},
    {1,3,6,3,9,6,2,2,9,8,4,4,9,9,6,8},
    {2,6,1,3,4,8,1,2,4,4,3,3,9,6,2,1},
    {3,1,2,4,4,3,1,0,1,6,5,8,6,1,3,4},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {3,1,2,4,4,3,1,1,3,2,1,1,1,1,1,1},
    {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
    {2,2,9,8,7,6,5,4,3,7,7,8,8,4,2,3},
    {4,3,1,7,3,4,2,8,5,9,4,3,3,2,1,0},
    {6,4,2,7,4,9,1,5,2,9,7,0,4,2,6,2},
    {5,3,7,2,8,1,9,2,4,3,9,9,9,7,6,0},
    {3,9,6,2,3,9,6,2,3,9,6,2,3,9,6,2},
    {2,9,8,4,2,4,2,6,3,8,8,7,6,9,1,1},
    {2,6,3,8,0,6,4,0,3,6,1,7,4,5,2,6},
    {2,6,1,3,4,8,4,6,0,3,2,9,8,4,2,1},
    {3,9,6,2,4,9,9,9,9,9,9,4,1,1,1,2},
    {1,3,6,3,9,6,2,2,9,8,4,4,9,9,6,8},
    {2,6,1,3,4,8,1,2,4,4,3,3,9,6,2,1},
    {3,1,2,4,4,3,1,0,1,6,5,8,6,1,3,4},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {3,1,2,4,4,3,1,1,3,2,1,1,1,1,1,1},
    {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
    {2,2,9,8,7,6,5,4,3,7,7,8,8,4,2,3},
    {4,3,1,7,3,4,2,8,5,9,4,3,3,2,1,0},
    {6,4,2,7,4,9,1,5,2,9,7,0,4,2,6,2},
    {5,3,7,2,8,1,9,2,4,3,9,9,9,7,6,0},
    {3,9,6,2,3,9,6,2,3,9,6,2,3,9,6,2},
    {2,9,8,4,2,4,2,6,3,8,8,7,6,9,1,1},
    {2,6,3,8,0,6,4,0,3,6,1,7,4,5,2,6}};//rows 0-63, cols 0-15
  
    
    @Test
    public void board8x8_start_at_row6col3(){
        assertEquals(37,Bubbles.bubbleMoney(board8x8,6,3));
    }

    @Test
    public void board8x8_start_at_row3col6(){
        assertEquals(23, Bubbles.bubbleMoney(board8x8,3,6));
    }

    @Test
    public void board8x8_start_in_top_left_corner(){
        assertEquals(2, Bubbles.bubbleMoney(board8x8,0,0));
    }

    @Test
    public void board8x8_start_in_bottom_right_corner(){
        assertEquals(35,Bubbles.bubbleMoney(board8x8,7,7));
    }

    @Test
    public void board8x8_start_in_top_right_corner(){
        assertEquals(6,Bubbles.bubbleMoney(board8x8,0,7));
    }

    @Test
    public void board4x4_start_in_bottom_row(){//row 3 col 2
        assertEquals(16,Bubbles.bubbleMoney(board4x4,3,2));
    }

    @Test
    public void board4x4_start_in_middle_row2col1(){
        assertEquals(10,Bubbles.bubbleMoney(board4x4,2,1));
    }

    @Test
    public void board4x4_start_in_top_left_corner(){
        assertEquals(2,Bubbles.bubbleMoney(board4x4,0,0));
    }

    @Test
    public void board4x4_start_in_top_right_corner(){
        assertEquals(1,Bubbles.bubbleMoney(board4x4,0,2));
    }

    @Test
    public void board4x4_start_in_bottom_left_corner(){
        assertEquals(13,Bubbles.bubbleMoney(board4x4,3,0));
    }

    @Test
    public void board4x4_start_in_bottom_right_corner(){
        assertEquals(13,Bubbles.bubbleMoney(board4x4,3,3));
    }


    @Test
    public void board8x3_start_in_bottom_left_corner(){
        assertEquals(42,Bubbles.bubbleMoney(board8x3,7,0));
    }

    @Test
    public void board8x3_start_in_bottom_right_corner(){
        assertEquals(40,Bubbles.bubbleMoney(board8x3,7,2));
    }

    @Test
    public void board8x3_start_on_right_edge(){
        assertEquals(19,Bubbles.bubbleMoney(board8x3,2,2));
    }

    @Test
    public void board8x3_start_in_top_left_corner(){
        assertEquals(3,Bubbles.bubbleMoney(board8x3,0,0));
    }

    @Test
    public void board8x3_start_in_top_right_corner(){
        assertEquals(8,Bubbles.bubbleMoney(board8x3,0,2));
    }


    @Test
    public void big_board_start_in_middle(){//last case, only 1 case to check that memoization was done
        assertEquals("Test will crash if solution isn't memoized",197,Bubbles.bubbleMoney(board64x16,30,9));
    }

}