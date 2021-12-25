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

import java.nio.file.Path;
import java.nio.file.Paths;

public class KaptchaMain {
    public static void main(String[] args) throws IOException {

        String folder = args[0];
        String img_width = args[1];
        String img_height = args[2];
        String font_size = args[3];
        String font_color = args[4];
        String char_string = args[5];
        String char_length = args[6];
        int num_samples = Integer.parseInt(args[7]);
        int add_space = Integer.parseInt(args[8]);        

//        String folder = "data";
//        String img_width = "200";
//        String img_height = "50";
//        String font_size = "50";
//        String font_color = "0,0,230";
//        String char_string = "0123456789";
//        String char_length = "5";
//        int num_samples = 2000;
//        int add_space = 22;

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path dataPath = Paths.get(currentPath.toString(), folder);
        System.out.println(dataPath.toString());
        new File(dataPath.toString()).mkdirs();


        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", img_width);
        properties.setProperty("kaptcha.image.height", img_height);
        properties.setProperty("kaptcha.textproducer.font.size ", font_size);
        properties.setProperty("kaptcha.textproducer.font.color", font_color);
        properties.setProperty("kaptcha.textproducer.char.string", char_string);
        properties.setProperty("kaptcha.textproducer.char.length", char_length);


        Config config = new Config(properties);
        
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(config);
        DefaultTextCreator textCreator = new DefaultTextCreator();
        textCreator.setConfig(config);
        String text_generated;
        String text_generated_captcha;
        for(int i=1;i<=num_samples;i++){  
            text_generated = textCreator.getText();
            text_generated_captcha = text_generated;
            if (add_space > 0){
                String str_space = String.join("", Collections.nCopies(add_space, " "));
                text_generated_captcha = text_generated + str_space;

            }
            BufferedImage image = kaptcha.createImage(text_generated_captcha);
            Path filePath = Paths.get(dataPath.toString(), text_generated + ".jpg");
            File output = new File(filePath.toString());
            ImageIO.write(image, "jpg", output); 
        }  

    }
}