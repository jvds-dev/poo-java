public class Map {
    private char[][] matrix;
    private int sizeX, sizeY;
    private char defautMapElement = '.';
    private ScreenManager screen = new ScreenManager();

    public Map(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.matrix = new char[x][y];
        initializeMap();
    }

    private void initializeMap(){
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                matrix[i][j] = defautMapElement;
            }
        }
    }

    public void displayMap(){
        for (char[] row : matrix){
            for(char c : row){
                switch(c){
                    case 'P':
                        System.out.print(screen.colorText(c + " ", screen.YELLOW));
                        break;
                    case 'E':
                        System.out.print(screen.colorText(c + " ", screen.RED));
                        break;
                    default:
                        System.out.print(screen.colorText(c + " ", screen.GREEN));
                        break;
                }
            }
            System.out.println();
        }
    }

    public boolean movePlayer(Player player, int newX, int newY){
        if(newX >= 0 && newX < sizeX && newY >= 0 && newY < sizeY){
            matrix[player.getX()][player.getY()] = defautMapElement;
            player.setPosition(newX, newY);
            matrix[newX][newY] = player.getMapElement();
            return true;
        }
        return false;
    }

    public void addElement(int x, int y, char element){
        matrix[x][y] = element;
    }
    public char getElement(int x, int y){
        return matrix[x][y];
    }

    public int getSizeX(){
        return sizeX;
    }
    public int getSizeY(){
        return sizeY;
    }

}