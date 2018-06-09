package cn.edu.bistu.cs.se.words.wordcantract;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * 一般需要为数据库中每个表创建一个“合约类（contract class）”，
 * 常在“合约类”中定义表名、列名、URI、Intent Actions以及Content Provider
 * 的其他特征等，用来帮助应用程序很好地工作，同时并减少模块间的耦合。
 */
public class Words {


   //单词列表项
   public static class WordItem {
        public String id;
        public String word;

        public WordItem(String id, String word) {
            this.id = id;
            this.word = word;
        }

        @Override
        public String toString() {
            return word;
        }
    }

    //每个单词的描述
    public static class WordDescription {
        public String id;
        public String word;
        public String meaning;
        public String sample;

        public WordDescription(String id, String word,String meaning, String sample) {
            this.id = id;
            this.word = word;
            this.meaning = meaning;
            this.sample = sample;
        }
    }

    public static final String AUTHORITY = "cn.edu.bistu.cs.se.wordsprovider";//声明了Uri的授权者名称

    public Words() {
    }

    //注意，接口BaseColumns接口有一个字段为"_ID",该字段对于ContentProvider非常重要

    /**
     * Word表共4个字段：_ID(从接口BaseColumns而来)、word、meaning、sample
     */
    public static abstract class Word implements BaseColumns {
        public static final String TABLE_NAME = "words";  //  声明表名
        public static final String COLUMN_NAME_WORD = "word";//字段：单词
        public static final String COLUMN_NAME_MEANING = "meaning";//字段：单词含义
        public static final String COLUMN_NAME_SAMPLE = "sample";//字段：单词示例

        //MIME类型
        public static final String MIME_DIR_PREFIX = "vnd.android.cursor.dir";
        public static final String MIME_ITEM_PREFIX = "vnd.android.cursor.item";
        public static final String MINE_ITEM = "vnd.bistu.cs.se.word";

        public static final String MINE_TYPE_SINGLE = MIME_ITEM_PREFIX + "/" + MINE_ITEM;
        public static final String MINE_TYPE_MULTIPLE = MIME_DIR_PREFIX + "/" + MINE_ITEM;

        public static final String PATH_SINGLE = "word/#";//定义单条数据的路径
        public static final String PATH_MULTIPLE = "word";//定义多条数据的路径

        //Content Uri
        public static final String CONTENT_URI_STRING = "content://" + AUTHORITY + "/" + PATH_MULTIPLE;
        public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    }
}