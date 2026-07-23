import java.util.*;

public class Level1
{
    public static void MatrixTurn(String Matrix[], int M, int N, int T)
      {
        char[][] matrixChars = new char[M][N];

        for (int i = 0; i < M; i++) {
            matrixChars[i] = Matrix[i].toCharArray();
        }

        int layerCount = Math.min(M, N) / 2;

        for (int layer = 0; layer < layerCount; layer++) {
            int topRow = layer;
            int leftColumn = layer;
            int bottomRow = M - 1 - layer;
            int rightColumn = N - 1 - layer;

            int layerSize = 2 * ((bottomRow - topRow + 1) + (rightColumn - leftColumn + 1)) - 4;
            int shift = T % layerSize;

            int[] rowIndices = new int[layerSize];
            int[] columnIndices = new int[layerSize];
            char[] layerValues = new char[layerSize];

            int position = 0;

            for (int column = leftColumn; column <= rightColumn; column++) {
                rowIndices[position] = topRow;
                columnIndices[position] = column;
                layerValues[position] = matrixChars[topRow][column];
                position++;
            }

            for (int row = topRow + 1; row <= bottomRow; row++) {
                rowIndices[position] = row;
                columnIndices[position] = rightColumn;
                layerValues[position] = matrixChars[row][rightColumn];
                position++;
            }

            for (int column = rightColumn - 1; column >= leftColumn; column--) {
                rowIndices[position] = bottomRow;
                columnIndices[position] = column;
                layerValues[position] = matrixChars[bottomRow][column];
                position++;
            }

            for (int row = bottomRow - 1; row > topRow; row--) {
                rowIndices[position] = row;
                columnIndices[position] = leftColumn;
                layerValues[position] = matrixChars[row][leftColumn];
                position++;
            }

            for (int i = 0; i < layerSize; i++) {
                int shiftedPosition = (i + shift) % layerSize;
                matrixChars[rowIndices[shiftedPosition]][columnIndices[shiftedPosition]] = layerValues[i];
            }
        }

        for (int row = 0; row < M; row++) {
            Matrix[row] = new String(matrixChars[row]);
        }
    }
}

