package com.saeed.kaptchagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.ImageIO;
import java.util.*;

import com.google.code.kaptcha.util.Config;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.text.impl.DefaultTextCreator;

public class KaptchaMain {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String Folder = args[0];
        String img_width = args[1];
        String img_height = args[2];
        String font_size = args[3];
        String font_color = args[4];
        String char_string = args[5];
        String char_length = args[6];
        int num_samples = Integer.parseInt(args[7]);
        int add_space = Integer.parseInt(args[8]);

//
//        String Folder = "data";
//        String img_width = "200";
//        String img_height = "50";
//        String font_size = "50";
//        String font_color = "0,0,230";
//        String char_string = "0123456789";
//        String char_length = "5";
//        int num_samples = 2000;
//        int add_space = 22;

        properties.setProperty("kaptcha.image.width", img_width);
        properties.setProperty("kaptcha.image.height", img_height);
        properties.setProperty("kaptcha.textproducer.font.size ", font_size);
        properties.setProperty("kaptcha.textproducer.font.color", font_color);
        properties.setProperty("kaptcha.textproducer.char.string", char_string);
        properties.setProperty("kaptcha.textproducer.char.length", char_length);

        new File(Folder).mkdirs();
        Config config = new Config(properties);
        
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(config);
        DefaultTextCreator textCreator = new DefaultTextCreator();
        textCreator.setConfig(config);
        String text_generated;
        for(int i=1;i<=num_samples;i++){  
            text_generated = textCreator.getText();
            if (add_space > 0){
                String str_space = String.join("", Collections.nCopies(add_space, " "));
                text_generated = text_generated + str_space;

            }
            BufferedImage image = kaptcha.createImage( text_generated);

            File output = new File( Folder + "\\" + text_generated + ".jpg");
            ImageIO.write(image, "jpg", output); 
        }  

    }
}