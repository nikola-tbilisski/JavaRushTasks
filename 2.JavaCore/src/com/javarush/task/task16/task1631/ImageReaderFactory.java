package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory
	{
		public static ImageReader getImageReader(ImageTypes readerType) throws IllegalArgumentException{

				if(readerType == null){
					throw new IllegalArgumentException();
				}
				else {
					switch (readerType) {
						case JPG: {
							return new JpgReader();
						}
						case BMP: {
							return new BmpReader();
						}
						case PNG: {
							return new PngReader();
						}

						default: {
							break;
						}
					}
				}
			return null;
		}
	}
