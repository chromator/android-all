package com.test.sax.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Main extends Activity {
	ExampleHandler handler;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        handler = new ExampleHandler();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.list_menu, menu);
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.add_item:
			try {
				parseXMLFile();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.quit:
			break;
			
		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
    
    private void parseXMLFile() throws ParserConfigurationException, SAXException, IOException {
    	SAXParserFactory saxFactory = SAXParserFactory.newInstance();
    	SAXParser parser = saxFactory.newSAXParser();
    	
    	InputStream in = this.getAssets().open("mod_success.txt");
    	
    	parser.parse(in, handler);
    	
    	ArrayList<Module> modulList = handler.getModuleList();
    	
    	for (Iterator iterator = modulList.iterator(); iterator.hasNext();) {
			Module module = (Module) iterator.next();
			Log.i("Main", "ModuleID-->"+module.getModuleID());
		}
    }
    
    private class ExampleHandler extends DefaultHandler {
    	
    	ArrayList moduleList;    	
    	
		Module module;
		boolean isModuleID;
    	
    	public ExampleHandler() {
    		moduleList = new ArrayList<Module>();
    	}
    	
    	public ArrayList getModuleList() {
			return moduleList;
		}

		public void setModuleList(ArrayList moduleList) {
			this.moduleList = moduleList;
		}
    	
    	@Override
    	public void startElement(String uri, String localName, String qName,
    			Attributes attributes) throws SAXException {
    		if(localName.equals("module")) {
    			module = new Module();
    		} else if(localName.equals("moduleID")) {
    			isModuleID = true;
    		}
    	}
    	
    	@Override
    	public void endElement(String uri, String localName, String qName)
    			throws SAXException {
    		if(localName.equals("moduleID")) {
    			isModuleID = false;
    			moduleList.add(module);
    		}
    	}
    	
    	@Override
    	public void characters(char[] ch, int start, int length)
    			throws SAXException {    		
    		if(isModuleID) {
    			module.setModuleID(new String(ch));
    		}
    	}
    	
    	@Override
    	public void startDocument() throws SAXException {    		
    		super.startDocument();
    	}
    	
    	@Override
    	public void endDocument() throws SAXException {    		
    		super.endDocument();
    	}
    }
    
    private class Module {
    	private String moduleID;    	
		private String moduleUserID;
    	private String moduleTitle;
    	private String moduleDescription;
    	private String moduleThumb;
    	private String moduleDateTime;
    	private ArrayList<ModuleImage> imageList;
    	private ArrayList<ModuleVideo> videoList;
    	
    	public String getModuleID() {
			return moduleID;
		}
		public void setModuleID(String moduleID) {
			this.moduleID = moduleID;
		}
		public String getModuleUserID() {
			return moduleUserID;
		}
		public void setModuleUserID(String moduleUserID) {
			this.moduleUserID = moduleUserID;
		}
		public String getModuleTitle() {
			return moduleTitle;
		}
		public void setModuleTitle(String moduleTitle) {
			this.moduleTitle = moduleTitle;
		}
		public String getModuleDescription() {
			return moduleDescription;
		}
		public void setModuleDescription(String moduleDescription) {
			this.moduleDescription = moduleDescription;
		}
		public String getModuleThumb() {
			return moduleThumb;
		}
		public void setModuleThumb(String moduleThumb) {
			this.moduleThumb = moduleThumb;
		}
		public String getModuleDateTime() {
			return moduleDateTime;
		}
		public void setModuleDateTime(String moduleDateTime) {
			this.moduleDateTime = moduleDateTime;
		}
		public ArrayList<ModuleImage> getImageList() {
			return imageList;
		}
		public void setImageList(ArrayList<ModuleImage> imageList) {
			this.imageList = imageList;
		}
		public ArrayList<ModuleVideo> getVideoList() {
			return videoList;
		}
		public void setVideoList(ArrayList<ModuleVideo> videoList) {
			this.videoList = videoList;
		}
    }
    
    private class ModuleImage {
    	private String imageID;    	
		private String imageThumbURL;
    	private String imageURL;
    	private String imageDateTime;
    	
    	public String getImageID() {
			return imageID;
		}
		public void setImageID(String imageID) {
			this.imageID = imageID;
		}
		public String getImageThumbURL() {
			return imageThumbURL;
		}
		public void setImageThumbURL(String imageThumbURL) {
			this.imageThumbURL = imageThumbURL;
		}
		public String getImageURL() {
			return imageURL;
		}
		public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
		}
		public String getImageDateTime() {
			return imageDateTime;
		}
		public void setImageDateTime(String imageDateTime) {
			this.imageDateTime = imageDateTime;
		}
    }
    
    private class ModuleVideo {
    	private String videoID;    	
		private String videoThumbURL;
    	private String videoURL;
    	private String videoDateTime;
    	
    	public String getVideoID() {
			return videoID;
		}
		public void setVideoID(String videoID) {
			this.videoID = videoID;
		}
		public String getVideoThumbURL() {
			return videoThumbURL;
		}
		public void setVideoThumbURL(String videoThumbURL) {
			this.videoThumbURL = videoThumbURL;
		}
		public String getVideoURL() {
			return videoURL;
		}
		public void setVideoURL(String videoURL) {
			this.videoURL = videoURL;
		}
		public String getVideoDateTime() {
			return videoDateTime;
		}
		public void setVideoDateTime(String videoDateTime) {
			this.videoDateTime = videoDateTime;
		}
    }
}