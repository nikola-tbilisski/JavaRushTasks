package com.javarush.task.task31.task3110;

public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod){
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public long getCompressedSize() {
        return compressedSize;
    }



    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
 //       long compressionRatio = getCompressionRatio();
//        if(size > 0) return String.format("%s %d KB (%d KB) сжатие: %d%%", name, (size / 1024), (compressedSize / 1024), getCompressionRatio());
//        else return name;
        return getSize() > 0
                ? String.format("%s %d Kb (%d Kb) сжатие: %d%%", name, size/1024, compressedSize/1024, getCompressionRatio())
                : name;
    }

//    @Override
//    public String toString() {
//        if(size>0)
//            return String.format("%s %d Kb (%d Kb) сжатие: %d %%",  name, size/1024, compressedSize/1024, getCompressionRatio());
//        else
//            return name;
//    }

//    @Override
//    public String toString() {
//        // Строим красивую строку из свойств
//        StringBuilder builder = new StringBuilder();
//        builder.append(name);
//        if (size > 0) {
//            builder.append("\t");
//            builder.append(size / 1024);
//            builder.append(" Kb (");
//            builder.append(compressedSize / 1024);
//            builder.append(" Kb) сжатие: ");
//            builder.append(getCompressionRatio());
//            builder.append("%");
//        }
//
//        return builder.toString();
//    }
}
