package com.example.camera;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

/**
 * �ļ�����������
 * @author linj
 *
 */

public class FileOperateUtil {

	public final static int ROOT=0;//��Ŀ¼
	public final static int TYPE_IMAGE=1;//ͼƬ
	public final static int TYPE_THUMBNAIL=2;//����ͼ
	public final static int TYPE_VEDIO=3;//��Ƶ

	/**
	 *��ȡ�ļ���·��
	 * @param type �ļ������
	 * @param rootPath ��Ŀ¼�ļ������� Ϊҵ����ˮ��
	 * @return
	 */
	public static String getFolderPath(Context context,int type,String rootPath) {
		//��ҵ���ļ���Ŀ¼
		StringBuilder pathBuilder=new StringBuilder();
		//����Ӧ�ô洢·��
		pathBuilder.append(context.getExternalFilesDir(null).getAbsolutePath());
		pathBuilder.append(File.separator);
		//�����ļ���Ŀ¼
		pathBuilder.append(context.getString(R.string.Files));
		pathBuilder.append(File.separator);
		//���ӵ�Ȼ�ļ�����·��
		pathBuilder.append(rootPath);
		pathBuilder.append(File.separator);
		switch (type) {
		case TYPE_IMAGE:
			pathBuilder.append(context.getString(R.string.Image));
			break;
		case TYPE_VEDIO:
			pathBuilder.append(context.getString(R.string.Vedio));
			break;
		case TYPE_THUMBNAIL:
			pathBuilder.append(context.getString(R.string.Thumbnail));
			break;
		default:
			break;
		}
		return pathBuilder.toString();
	}

	/**
	 * ��ȡĿ���ļ�����ָ����׺�����ļ�����
	 * @param file Ŀ���ļ���·��
	 * @param format ָ����׺��
	 * @return
	 */
	public static File[] listFiles(String file,final String format){
		return listFiles(new File(file), format);
	}
	/**
	 * ��ȡĿ���ļ�����ָ����׺�����ļ�����
	 * @param file Ŀ���ļ���
	 * @param format ָ����׺��
	 * @return
	 */
	public static File[] listFiles(File file,final String extension){
		File[] files=null;
		if(file==null||!file.exists()||!file.isDirectory())
			return null;
		files=file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg1.endsWith(extension);
			}
		});
		return files;
	}

	/**
	 * 
	 * @param extension ��׺�� ��".jpg"
	 * @return
	 */
	public static String createFileNmae(String extension){
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss",Locale.getDefault());
		// ת��Ϊ�ַ���
		String formatDate = format.format(new Date());
		//�鿴�Ƿ��"."
		if(!extension.startsWith("."))
			extension="."+extension;
		return formatDate+extension;
	}
}