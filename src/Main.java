import models.Points;
import models.RightTriangle;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String fileAddress = "C:\\Users\\Berik\\IdeaProjects\\PW275\\src\\Source.txt";
        System.out.println("Enter the number of right triangles to generate randomly");
        int n = sc.nextInt();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileAddress));
            for (int i = 0; i < n; i++) {
                writer.write(random.nextInt(101) + "," + random.nextInt(101)
                        + "," + random.nextInt(101) + "," + random.nextInt(101));
                writer.write("\n");
            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        ArrayList<Points> points = new ArrayList<Points>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] integers = line.split(",");
                int x1 = Integer.parseInt(integers[0]);
                int y1 = Integer.parseInt(integers[1]);
                int x2 = Integer.parseInt(integers[2]);
                int y2 = Integer.parseInt(integers[3]);
                points.add(new Points(x1, y1, x2, y2));
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        ArrayList<RightTriangle> triangles = new ArrayList<RightTriangle>();
        for (Points p : points) {
            triangles.add(new RightTriangle(p.base(), p.height(), p.hypotenuse()));
        }

        for (int i = 0; i < n; i++) {
            double p = triangles.get(i).perimeter();
            double a = triangles.get(i).area();
            System.out.println(((i + 1 == 1) ? "1st" : (i + 1 == 2) ? "2nd" : (i + 1 == 3) ? "3rd" : (i + 1) + "th")
            + " triangle has perimeter of " + p + " and area of " + a);
        }
    }
}