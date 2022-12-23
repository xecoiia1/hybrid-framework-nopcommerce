package pageObject.sauceLab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonJquery.BasePageJquery;
import pageUI.sauceLab.ProductPageUI;

public class ProductPageObj extends BasePageJquery {
		
	WebDriver driver;
	
	public ProductPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickAble(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemDefaulDropDown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
		
	}

	public boolean isProductNameSortByAscending() {
		//Khai báo 1 array list để chứa các product name trên UI.
		ArrayList<String> productUIList = new ArrayList<>();
		
		//Lấy ra hết các text chứa product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		//Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		
		//Sau đó tạo ra 1 Array List mới để sort dữ liệu
		ArrayList<String> productSortList = new ArrayList<>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		//Sort Product SortList
		Collections.sort(productUIList);
		
		//So sánh 2 list với nhau
		
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		//Khai báo 1 array list để chứa các product name trên UI.
		ArrayList<String> productUIList = new ArrayList<>();
		
		//Lấy ra hết các text chứa product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		//Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		
		//Sau đó tạo ra 1 Array List mới để sort dữ liệu
		ArrayList<String> productSortList = new ArrayList<>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		
		//Sort Product SortList
		Collections.sort(productSortList);
		
		//Reverse Product SortList
		Collections.reverse(productUIList);
		
		//So sánh 2 list với nhau
		
		return productSortList.equals(productUIList);
		
	}

	public boolean isProductPriceSortByAscending() {
		//Khai báo 1 array list để chứa các product name trên UI.
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		//Lấy ra hết các text chứa product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		
		//Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement priceText : productPriceText) {
			productUIList.add(Float.parseFloat(priceText.getText().replace("$", "")));
		}
		
		//Sau đó tạo ra 1 Array List mới để sort dữ liệu
		ArrayList<Float> priceSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			priceSortList.add(product);
		}
		
		//Sort Product SortList
		Collections.sort(priceSortList);
		
		//So sánh 2 list với nhau
		
		return priceSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		//Khai báo 1 array list để chứa các product name trên UI.
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		//Lấy ra hết các text chứa product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		
		//Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement priceText : productPriceText) {
			productUIList.add(Float.parseFloat(priceText.getText().replace("$", "")));
		}
		
		//Sau đó tạo ra 1 Array List mới để sort dữ liệu
		ArrayList<Float> priceSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			priceSortList.add(product);
		}
		
		//Sort Product SortList
		Collections.sort(priceSortList);
		
		//Reverse Product SortList
		Collections.reverse(priceSortList);
		
		//So sánh 2 list với nhau
		
		return priceSortList.equals(productUIList);
	}
	


	
}
