public class Map {
    private char[][] matrix;
    private int sizeX, sizeY;

    public Map(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.matrix = new char[x][y];
        initializeMap();
    }

    private void initializeMap(){
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                matrix[i][j] = '-';
            }
        }
    }

    public void displayMap(){
        for (char[] row : matrix){
            for(char c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public boolean movePlayer(Player player, int newX, int newY){
        if(newX >= 0 && newX < sizeX && newY >= 0 && newY < sizeY){
            matrix[player.getX()][player.getY()] = '-';
            player.setPosition(newX, newY);
            matrix[newX][newY] = 'P';
            return true;
        }
        return false;
    }

    public void addElement(int x, int y, char element){
        matrix[x][y] = element;
    }

}