import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    public static void main(String[] args)
    {
        ArrayList<String> listOne = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        ShortWordFilter filter = new ShortWordFilter();
        File selecctedFile;

        String data = "";
        String word = "";



        try
        {
        File Worddata = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(Worddata);


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));


                System.out.printf("%-10s", "Words under 5 letters");
                System.out.printf("%n=================%n");



                while (reader.ready())
                {
                    data = reader.readLine();
                    String[] arrOfdata = data.split(", ", 1);

                    word = arrOfdata[0];
                    listOne.add(word);
                }


                reader.close();
                String[] fields;


                for (String l: listOne)
                {
                    fields = l.split(" ");

                    for (String w: fields)
                    {
                        if (filter.accept(w))
                        {
                            System.out.println(w.trim());
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
