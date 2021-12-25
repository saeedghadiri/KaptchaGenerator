# KaptchaGenerator
## What is kaptcha
Kaptcha is one of the most famous libraries used in websites in order to create captchas. The generated captcha usually looks like this:
![Alt text](/samples/1.jpg?raw=true "Title")
![Alt text](/samples/2.png?raw=true "Title")
![Alt text](/samples/3.png?raw=true "Title")

## What is KaptchaGenerator
This is just a simple approach in order to generate captcha files for your data science project.

## How to use
1. Install java se development kit.
2. Copy `kaptchagenerator.jar` from this project to a folder.
3. Change directody to the folder using command line.
4. Run `java -jar kaptchagenerator.jar target_folder img_width img_height font_size font_color char_string char_length num_samples add_space`


`target_folder` is the path for the destination folder.

`img_width` is the image's width.

`img_height` is the image's height.

`font_size` is the text's font size.

`font_color`  is the text's font color in rgb. for example `0,00,230`

`char_string` is the pool of chars from which the characters are sampled. for example `0123456789`

`char_length` is the generated text's length.

`num_samples` is the number of samples generated.

`add_space` is the number of spaces added before the text. if the generated text needs no space use `0`

A simple call to generate above captchas would be `java -jar kaptchagenerator.jar data 200 50 50 0,00,230 0123456789 5 1000 22`
