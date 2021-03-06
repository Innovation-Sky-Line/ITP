package com.ossms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.DocumentException;
import com.ossms.model.DiscountExportPDF;
import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductList;
import com.ossms.model.ProductModel;
import com.ossms.model.ProductPDFexporter;
import com.ossms.model.ShoppingCart;
import com.ossms.model.Supplier;
import com.ossms.service.CartServiceImpl;
import com.ossms.service.ProductService;

@Controller
@RequestMapping(value = "/padmin")
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CartServiceImpl cs = new CartServiceImpl();

	@RequestMapping(value = "/proManage")
	public ModelAndView addProducts() {
		ModelAndView model = new ModelAndView("ProManage/Padmin");
		ProductModel product = new ProductModel();
		model.addObject("productForm", product);
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = productService.subCategoryNames();
		model.addObject("allCategories", allCategories);
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);
		List<ProductCategoryModel> allCategories2 = productService.allCategoryNames();
		model.addObject("allCategories2", allCategories2);

		return model;
	}

	@RequestMapping(value = "/CateManage")
	public ModelAndView addCategory() {
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);
		ProductCategoryModel category = new ProductCategoryModel();
		model.addObject("categoryForm", category);

		return model;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(ProductModel product) {
		ModelAndView model = new ModelAndView();
		productService.saveOrUpdate(product);

		model.setViewName("redirect:/padmin/productList3");

		return model;
	}

	@RequestMapping(value = "/getSubs/{id}", method = RequestMethod.GET)
	public ModelAndView addProduct(ProductCategoryModel cat,@PathVariable Integer id) {
		ModelAndView model = new ModelAndView("ProManage/Padmin");
		ProductModel product = new ProductModel();
		model.addObject("productForm", product);
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		model.addObject("subCate", cat);

		return model;
	}

	@RequestMapping(value = "/addProduct2", method = RequestMethod.POST)
	public ModelAndView addProduct(ProductModel product, @RequestParam("image") MultipartFile mFile)
			throws IOException {
		ModelAndView model = new ModelAndView();
		if (productService.existsByProductName(product.getProductName())) {
			model.setViewName("ProManage/Exist_Erorr");
			return model;
		}

		String fileName = StringUtils.cleanPath(mFile.getOriginalFilename());
		product.setProductImage(fileName);
		productService.saveOrUpdate(product);
		if (fileName == "") {
			model.setViewName("redirect:/padmin/productList3");
			return model;
		}
		String dir = "src/main/webapp/resources/Product-Images";
		java.nio.file.Path path = Paths.get(dir);
		if (!Files.exists(path)) {
			Files.createDirectories(path);
		}
		try (InputStream inputStream = mFile.getInputStream()) {
			java.nio.file.Path filePath = path.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());

			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {

			throw new IOException("Could not save image file: " + fileName, e);
		}
		;

		model.setViewName("redirect:/padmin/productList3");

		return model;
	}

	@RequestMapping(value = "/updateProduct2", method = RequestMethod.POST)
	public ModelAndView updateProduct(ProductModel product, @RequestParam("image") MultipartFile mFile)
			throws IOException {
		ModelAndView model = new ModelAndView();
//	  if(productService.existsByProductName(product.getProductName())) {
//		  model.setViewName("ProManage/Exist_Erorr");
//		  return model;
//	  }

		String fileName = StringUtils.cleanPath(mFile.getOriginalFilename());
		product.setProductImage(fileName);
		productService.saveOrUpdate(product);
		if (fileName == "") {
			model.setViewName("redirect:/padmin/productList3");
			return model;
		}
		String dir = "src/main/webapp/resources/Product-Images";
		java.nio.file.Path path = Paths.get(dir);
		if (!Files.exists(path)) {
			Files.createDirectories(path);
		}
		try (InputStream inputStream = mFile.getInputStream()) {
			java.nio.file.Path filePath = path.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());

			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {

			throw new IOException("Could not save image file: " + fileName, e);
		}
		;

		model.setViewName("redirect:/padmin/productList3");

		return model;
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(ProductCategoryModel category) {
		ModelAndView model = new ModelAndView();
		productService.saveOrUpdate(category);
		model.setViewName("redirect:/padmin/categoryList");

		return model;
	}

	@RequestMapping(value = "/addCategory1", method = RequestMethod.POST)
	public ModelAndView addCategory1(@ModelAttribute("categoryForm") ProductCategoryModel cat) {
		ModelAndView model = new ModelAndView();

		productService.saveOrUpdate(cat);
		model.setViewName("redirect:/padmin/categoryList2");

		return model;
	}

	@RequestMapping(value = "/proAdmin")
	public ModelAndView productAdmin() {
		ModelAndView model = new ModelAndView("ProManage/Padmin");
		ProductModel product = new ProductModel();
		model.addObject("productForm", product);
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = productService.allCategoryNames();
		model.addObject("allCategories", allCategories);
		return model;
	}

	@RequestMapping(value = "/cphp")
	public ModelAndView productHome() {
		ModelAndView model = new ModelAndView("ProManage/CusProductHome");
		ProductModel product = new ProductModel();
		model.addObject("productForm", product);
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = productService.allCategoryNames();
		model.addObject("allCategories", allCategories);
		List<ProductCategoryModel> subCategories = productService.subCategoryNames();
		model.addObject("subCategories", subCategories);
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);
		List<ProductModel> p = productService.getDiscountProducts();
		model.addObject("discounted", p);
		List<ProductModel> topList= productService.topTwentyProducts();
		model.addObject("topList", topList);
		return model;
	}
	
	@RequestMapping(value = "/categoryProducts/{id}", method = RequestMethod.GET)
	public ModelAndView categoryProducts(@PathVariable Integer id, HttpSession session) {
		ModelAndView model = new ModelAndView("ProManage/CategoryProducts");
		List<ProductCategoryModel> allCategories = productService.allCategoryNames();
		model.addObject("allCategories", allCategories);
		List<ProductModel> p = productService.getCateProducts(id);
		model.addObject("discounted", p);
		if(session.getAttribute("orderId") != null) {
			List<ShoppingCart> cart = cs.getItemsInCart((int)session.getAttribute("orderId"));
			model.addObject("itemsInCart", cart.size());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/discountedProducts")
	public ModelAndView discountedProducts(HttpSession session) {
		ModelAndView model = new ModelAndView("ProManage/DiscountedProducts");
		List<ProductCategoryModel> allCategories = productService.allCategoryNames();
		model.addObject("allCategories", allCategories);
		List<ProductModel> p = productService.getDiscountProducts();
		model.addObject("discounted", p);
		List<ShoppingCart> cart = cs.getItemsInCart((int)session.getAttribute("orderId"));
		model.addObject("itemsInCart", cart.size());
		return model;
	}

	@RequestMapping(value = "/myProfile")
	public ModelAndView profile() {
		ModelAndView model = new ModelAndView("ProManage/myProfile");
		return model;
	}

	@RequestMapping(value = "/proCate")
	public ModelAndView productCategory() {
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);
		ProductCategoryModel category = new ProductCategoryModel();
		model.addObject("categoryForm", category);

		return model;
	}

	@RequestMapping(value = "/proRepo")
	public ModelAndView productReports() {
		ModelAndView mv = new ModelAndView("ProManage/ProReport");
		List<ProductModel> products = productService.getInsufficientProducts();
		List<ProductList> pList = new ArrayList<ProductList>();
		for (ProductModel productModel : products) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);

			pList.add(list);
		}
		mv.addObject("insufficient", pList);

		List<ProductModel> p = productService.getDiscountProducts();
		List<ProductList> pList2 = new ArrayList<ProductList>();
		for (ProductModel productModels : p) {
			ProductCategoryModel categoryModel2 = productService.getCategoryById(productModels.getCategoryId());
			Supplier supplier2 = productService.getSupplierById(productModels.getSupplierId());
			ProductList list2 = new ProductList(productModels, categoryModel2, supplier2);

			pList2.add(list2);
		}
		mv.addObject("discounted", pList2);
		return mv;
	}

//	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
//	 public ModelAndView save(@ModelAttribute("productForm") ProductModel product) {
//		productService.saveOrUpdate(product);
//	  
//	  return new ModelAndView("redirect:/padmin/proAdmin");
//	 }

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("ProManage/ProductList");
		List<ProductModel> productList = productService.getAllproducts();
		model.addObject("productList", productList);

		return model;
	}

	@RequestMapping(value = "/productList2", method = RequestMethod.GET)
	public ModelAndView proList() {
		ModelAndView mv = new ModelAndView("ProManage/ProductList");
		List<ProductModel> products = productService.productList();
		List<ProductList> pList = new ArrayList<ProductList>();
		for (ProductModel productModel : products) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);

			pList.add(list);
		}
		if (!products.isEmpty()) {

			mv.addObject("productList", pList);
			return mv;
		} else {
			mv.setViewName("ProManage/Error");
			return mv;
		}

	}

	@RequestMapping(value = "/productList3", method = RequestMethod.GET)
	public ModelAndView proLastList(Model model) {
		ModelAndView mv = new ModelAndView("ProManage/ProductList");
		List<ProductModel> products = productService.productList();
		List<ProductList> pList = new ArrayList<ProductList>();
		for (ProductModel productModel : products) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);
			float price = productModel.getPrice();
			float dis = productModel.getDiscount();
			float fPrice = price - price * dis / 100;

			model.addAttribute("finalPrice", fPrice);
			pList.add(list);
		}
		if (!products.isEmpty()) {
			String str = "Product Added/Updated Successfully.";
			model.addAttribute("suc", str);
			mv.addObject("productList", pList);
			return mv;
		} else {
			mv.setViewName("ProManage/Error");
			return mv;
		}

	}

	@RequestMapping(value = "/updateProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int idProduct) {
		ModelAndView model = new ModelAndView();
		ProductModel product = productService.getProductById(idProduct);

		Supplier supplier = productService.getSupNamebyId(product.getSupplierId());
		String sName = supplier.getSupplierName();
		int sId = supplier.getIdSupplier();
		model.addObject("sName", sName);
		model.addObject("sId", sId);

		ProductCategoryModel pc = productService.cateNameById(product.getCategoryId());
		String cName = pc.getCategoryName();
		Integer cId = pc.getIdCategory();
		model.addObject("cName", cName);
		model.addObject("cId", cId);

		model.addObject("productForm", product);
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = productService.subCategoryNames();
		model.addObject("allCategories", allCategories);
		model.setViewName("ProManage/UpdateProduct");

		return model;
	}

	@RequestMapping(value = "/deleteProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idProduct") int idProduct) {
		productService.deleteProduct(idProduct);

		return new ModelAndView("redirect:/padmin/productList2");
	}

	@RequestMapping(value = "/deleteProduct2/{idProduct}", method = RequestMethod.GET)
	public ModelAndView delete2(@PathVariable("idProduct") int idProduct) {
		productService.deleteProduct(idProduct);

		return new ModelAndView("redirect:/padmin/proAdmin");
	}

	@RequestMapping(value = "/categoryList", method = RequestMethod.GET)
	public ModelAndView cateList() {
		ModelAndView model = new ModelAndView("ProManage/ProCateList");
		List<ProductCategoryModel> categoryList = productService.cateList();
		List<ProductCategoryModel> mainCate = productService.mainCategories();
		model.addObject("categoryList", categoryList);
		model.addObject("mainCategoryList", mainCate);
		return model;
	}

	@RequestMapping(value = "/categoryList2", method = RequestMethod.GET)
	public ModelAndView cateLastList(Model m) {
		ModelAndView model = new ModelAndView("ProManage/ProCateList");
		List<ProductCategoryModel> categoryList = productService.cateList();
		List<ProductCategoryModel> mainCate = productService.mainCategories();
		if (!categoryList.isEmpty()) {
			String str = "Category Added/Updated Successfully.";
			m.addAttribute("suc", str);
			model.addObject("categoryList", categoryList);
			model.addObject("mainCategoryList", mainCate);
			return model;
		} else {

			model.setViewName("ProManage/Error");
			return model;
		}

	}

	@RequestMapping(value = "/updateCategory/{idCategory}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable int idCategory) {
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		ProductCategoryModel category = productService.getCategoryById(idCategory);
		model.addObject("categoryForm", category);
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);

		return model;
	}

	@RequestMapping(value = "/deleteCategory/{idCategory}", method = RequestMethod.GET)
	public ModelAndView cateDelete(@PathVariable("idCategory") int idCategory) {
		productService.deleteCategory(idCategory);

		return new ModelAndView("redirect:/padmin/categoryList");
	}

	@RequestMapping(value = "/deleteCategory2/{idCategory}", method = RequestMethod.GET)
	public ModelAndView cateDelete2(@PathVariable("idCategory") int idCategory) {
		productService.deleteCategory(idCategory);

		return new ModelAndView("redirect:/padmin/proCate");
	}

	@RequestMapping(value = "/searchCate", method = RequestMethod.POST)
	public ModelAndView searchCategory(@RequestParam("searchCate") String name, Model model) {
		ModelAndView mView = new ModelAndView("ProManage/SearchedCategories");
		List<ProductCategoryModel> cat = productService.searchCategory(name);
		List<ProductCategoryModel> mainCate = productService.mainCategories();
		if (!cat.isEmpty()) {
			mView.addObject("SearchedCategoryList", cat);
			mView.addObject("mainCategoryList", mainCate);

			return mView;
		} else {
			String string = "Oops...No Matching Category Found!!!";
			model.addAttribute("fail", string);
			mView.setViewName("ProManage/SearchedCategories");
			return mView;
		}
	}

	@RequestMapping(value = "/searchPro", method = RequestMethod.POST)
	public ModelAndView searchProduct(@RequestParam("product") String name, Model model) {
		ModelAndView mv = new ModelAndView("ProManage/SearchedProducts");
		List<ProductModel> pro = productService.searchProduct(name);
		List<ProductList> pList = new ArrayList<ProductList>();
		for (ProductModel productModel : pro) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);

			pList.add(list);
		}

		if (!pro.isEmpty()) {
			mv.addObject("SearchedroductList", pList);
			return mv;
		} else {
			String string = "Oops...No Matching Product Found!!!";
			model.addAttribute("fail", string);
			mv.setViewName("ProManage/SearchedProducts");
			return mv;
		}
	}

	@RequestMapping(value = "/proReport", method = RequestMethod.GET)
	public ModelAndView proReport() {
		ModelAndView mv = new ModelAndView("ProManage/ProReport");
		List<ProductModel> products = productService.getInsufficientProducts();
		List<ProductList> pList = new ArrayList<ProductList>();
		for (ProductModel productModel : products) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);

			pList.add(list);
		}
		mv.addObject("insufficient", pList);
		return mv;
	}

	@RequestMapping(value = "/disProReport", method = RequestMethod.GET)
	public ModelAndView disProReport() {
		ModelAndView mv = new ModelAndView("ProManage/DisReports");

		List<ProductModel> p = productService.getDiscountProducts();
		List<ProductList> pList2 = new ArrayList<ProductList>();
		for (ProductModel productModels : p) {
			ProductCategoryModel categoryModel2 = productService.getCategoryById(productModels.getCategoryId());
			Supplier supplier2 = productService.getSupplierById(productModels.getSupplierId());
			ProductList list2 = new ProductList(productModels, categoryModel2, supplier2);

			pList2.add(list2);
		}
		mv.addObject("discounted", pList2);
		return mv;
	}

	@RequestMapping("/exportProductPdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTimeString = dateFormat.format(new Date());

		String headerKeyString = "Content-Disposition";
		String headerValue = "attachment; filename=Insufficient_products_" + currentDateTimeString + ".pdf";
		response.setHeader(headerKeyString, headerValue);

		List<ProductModel> products = productService.getInsufficientProducts();
		List<ProductList> pList = new ArrayList<ProductList>();
		for (ProductModel productModel : products) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);

			pList.add(list);
		}

		ProductPDFexporter productPDFexporter = new ProductPDFexporter(pList);
		productPDFexporter.export(response);

	}

	@RequestMapping("/disExportProductPdf")
	public void disExportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTimeString = dateFormat.format(new Date());

		String headerKeyString = "Content-Disposition";
		String headerValue = "attachment; filename=Discounted_products_" + currentDateTimeString + ".pdf";
		response.setHeader(headerKeyString, headerValue);

		List<ProductModel> p = productService.getDiscountProducts();
		List<ProductList> pList2 = new ArrayList<ProductList>();
		for (ProductModel productModels : p) {
			ProductCategoryModel categoryModel2 = productService.getCategoryById(productModels.getCategoryId());
			Supplier supplier2 = productService.getSupplierById(productModels.getSupplierId());
			ProductList list2 = new ProductList(productModels, categoryModel2, supplier2);

			pList2.add(list2);
		}

		DiscountExportPDF discountExportPDF = new DiscountExportPDF(pList2);
		discountExportPDF.export(response);

	}

}
