# photo-editor
Program that you can edit your photo with common filters. E.g. blur, sepia, greyscale.
Entire program is wrote in java language.
To run this program you can use a compiler or run it with your system console.
Instruction:
1. Open your system console in src/
2. use command: javac PhotoEditor.java
3. use command: java PhotoEditor photo_name.png new_photo_name.png

Remember that your photo has to be in img/

# Edges

![tower](https://user-images.githubusercontent.com/98922518/162848818-015dd81c-37d1-4403-9330-f093eef7d654.png)
![edges_tower](https://user-images.githubusercontent.com/98922518/162848827-814dc917-eef9-46e6-8b3f-abdba5dfca5f.png)

This filter use sobel operator. Every pixel get value of surrounding pixels modified by two kernals gx and gy.

# Greyscale

![courtyard](https://user-images.githubusercontent.com/98922518/162847679-c2694a46-9d33-4443-a848-0ba6416cf804.png)
![greyscale_courtyard](https://user-images.githubusercontent.com/98922518/162847691-6fe028b5-c1e7-404a-9342-f8fe91c327a1.png)

This filter takes rgb value of pixel, and change it to its average.

# Reflection

![courtyard](https://user-images.githubusercontent.com/98922518/162848120-d13e9361-13c3-4960-9ef9-d6dac0d1dc3c.png)
![reflection_courtyard](https://user-images.githubusercontent.com/98922518/162848122-0b13cb5b-d353-4e1c-be7a-68c493e8e1ad.png)

This filter makes mirror reflection.

# Blur

![stadium](https://user-images.githubusercontent.com/98922518/162848599-269da957-1934-4e7c-917e-260c731e8036.png)
![blur_stadium](https://user-images.githubusercontent.com/98922518/162848608-7ea87ee7-4315-41c7-96dc-7de2e8b4efda.png)

This filter makes blured photo. It takes an average value of surrounding pixels.

# Sepia

![yard](https://user-images.githubusercontent.com/98922518/162848400-eae4d594-6047-4de0-afcc-aae572c0d0c9.png)
![sepia_yard](https://user-images.githubusercontent.com/98922518/162848408-ddd4d4fd-554d-47ca-bd4c-667446ecc3c6.png)

This filter makes sepia of the photo.

