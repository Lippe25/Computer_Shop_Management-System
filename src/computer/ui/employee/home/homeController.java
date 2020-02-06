package computer.ui.employee.home;

import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import computer.classes.*;
import computer.databate.SuperController;
import javafx.animation.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class homeController implements Initializable {


    @FXML
    private StackPane rootSPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane rootPane2;

    @FXML
    private AnchorPane bodyArticles;

    @FXML
    private AnchorPane bodyHome;

    @FXML
    private AnchorPane bodyBill;

    @FXML
    private AnchorPane bodyCustomer;

    @FXML
    private AnchorPane bodyBalanceSheet;

    @FXML
    private Pane billPreviewPane;

    @FXML
    private ImageView img1;

    @FXML
    private Label lbl1 ;

    @FXML
    private ImageView img2;

    @FXML
    private Label lbl2;

    @FXML
    private ImageView img3;

    @FXML
    private Label lbl3;

    @FXML
    private ImageView img4;

    @FXML
    private Label lbl4;

    @FXML
    private ImageView img5;

    @FXML
    private Label lbl5;

    @FXML
    private ImageView img6;

    @FXML
    private Label lbl6;

    @FXML
    private ImageView img7;

    @FXML
    private Label lbl7;

    @FXML
    private ImageView img8;

    @FXML
    private Label lbl8;

    @FXML
    private ImageView img9;

    @FXML
    private Label lbl9;

    @FXML
    private Pane view1;

    @FXML
    private Pane paneSearch;

    @FXML
    private Label valMsg;

    @FXML
    private TextField search;

    @FXML
    private Pane header;

    @FXML
    private Pane article;

    @FXML
    private ImageView img;

    @FXML
    private Label serialNumber;

    @FXML
    private Label manufactury;

    @FXML
    private Label modelName;

    @FXML
    private Label catName;

    @FXML
    private Label price;

    @FXML
    private Label lblDiscount;

    @FXML
    private AnchorPane rootPane1;

    @FXML
    private Pane Bill;

    @FXML
    private Pane User;

    @FXML
    private Label billTotal1;

    @FXML
    private Label billSubTotal;

    @FXML
    private Label billDiscountValue;

    @FXML
    private Label billDiscount;

    @FXML
    private JFXButton billOff;

    @FXML
    private Label billRefund;

    @FXML
    private Label billTransport;

    @FXML
    private Label billPaid;

    @FXML
    private Label billTotal2;

    @FXML
    private Label billTVAValue;

    @FXML
    private Label billTVA;

    @FXML
    private Label billBalance;

    @FXML
    private Label storeName;

    @FXML
    private Label storeAddress;

    @FXML
    private Label storeNumber;

    @FXML
    private Label storeEmail;

    @FXML
    private Label sellingDate;

    @FXML
    private Label billNumber;

    @FXML
    private Label cusFirstNames;

    @FXML
    private Label cusLastName;

    @FXML
    private Label cusNumber;

    @FXML
    private Label cusAddress;

    @FXML
    private Label empName;

    @FXML
    private Label qtyRefund0;

    @FXML
    private Label Refund0;

    @FXML
    private Label lbl;

    @FXML
    private Label fullDate;

    @FXML
    private Label hour;

    @FXML
    private Label totalPreview;

    @FXML
    private Label footerUserName;

    @FXML
    private Label footerStoreLocation;

    @FXML
    private Rectangle tagPane;

    @FXML
    private JFXButton btnArt;

    @FXML
    private JFXButton btnCus;

    @FXML
    private JFXButton btnBil;

    @FXML
    private JFXButton btnBal;

    @FXML
    private JFXButton btnAddBill;

    @FXML
    private JFXButton btnFullView;

    @FXML
    private TextField amountPaid;

    @FXML
    private Label countArticle;

    @FXML
    private Label countCustomer;

    @FXML
    private JFXTextField newCustFName;

    @FXML
    private JFXTextField newCustLName;

    @FXML
    private JFXTextField newCustPhone;

    @FXML
    private JFXTextField newCustAddress;

    @FXML
    private JFXTextField newCustEmail;

    @FXML
    private JFXRadioButton newCustGenderM;

    @FXML
    private JFXRadioButton newCustGenderF;

    @FXML
    private JFXButton newCustPicture;

    @FXML
    private JFXButton newCustPictureV;

    @FXML
    private ImageView newCustPicture0;

    @FXML
    private ComboBox<Customer> cbCustomer;

    @FXML
    private ComboBox<Transport> cbTransport;

    @FXML
    private TableView<ArticleClassTab> articlesTable;

    @FXML
    private TableColumn<ArticleClassTab, String> serialNumberCol;

    @FXML
    private TableColumn<ArticleClassTab, String> articleNamesCol;

    @FXML
    private TableColumn<ArticleClassTab, Integer> priceCol;


    @FXML
    private TableView<AllArticleClassTab> AllArticlesTable;

    @FXML
    private TableColumn<AllArticleClassTab, String> allSerialNumberCol;

    @FXML
    private TableColumn<AllArticleClassTab, String> allManufacturyNameCol;

    @FXML
    private TableColumn<AllArticleClassTab, String> allModelNameCol;

    @FXML
    private TableColumn<AllArticleClassTab, String> allCategoryNameCol;

    @FXML
    private TableColumn<AllArticleClassTab, Integer> allPriceCol;

    private DateController dtn = new DateController();
    private SuperController supController = new SuperController();
    private Article articleFound;

    private List<Article> listArticles = new ArrayList<>();
    private ObservableList<ArticleClassTab> artsList = FXCollections.observableArrayList();  //For bill's articles
    private ObservableList<AllArticleClassTab> allArtsList = FXCollections.observableArrayList();  //For all the articles
    private ObservableList<String> customerComboBox = FXCollections.observableArrayList();  //For loading the customer combo box
    private ObservableList<String> transportComboBox = FXCollections.observableArrayList();  //For loading the transport combo box

    private Employee employeeInformations;
    private Bill bill;
    private List<Store> employeeStore = new ArrayList<>();
    private List<Object> allAccountingTab = new ArrayList<>();

    private int totalPrw = 0;

    private int addTransportPrice = 0;
    private int liteArticleSize = 0;
    private FileChooser fileChooser;
    private File file;
    private Window primaryStage;
    private Timer timer = new Timer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        initColArticle();
        AllFirstLoadArticles();

        loadCust();
        loadTrans();
        fullDate.setText(dtn.getFullDate());

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, event -> {
            //LocalTime currentTime = LocalTime.now();
            //hour.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond() + ":" + currentTime.);
            hour.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private List<Object> accounting(){
        int amountP = 0;

        int total = 0;
        int subTotal = 0;
        int qtyA = 0;
        int allDiscount = 0;
        int allRefund = 0;
        int balance = 0;
        float tva = 0;
        int tvaValue = 0;

        for (Article arti : listArticles) {
            for (Article art: listArticles) {
                if (arti.getCategory().getName().equals(art.getCategory().getName())){
                    qtyA += 1;
                }
            }

            if (arti.getCategory().getSurplusCount() != 0 && arti.getCategory().getSurplusCount() <= qtyA){
                int refund = (int) ((arti.getSellingPrice() * arti.getCategory().getSurplus())/100);

                allRefund += refund;  //Keep all refund values
                System.out.println(allRefund);
                total = (arti.getSellingPrice() - refund);  //Keep total price
            }

            int discount = (int) ((arti.getSellingPrice() * arti.getDiscount())/100);
            allDiscount = allDiscount + discount;  //Keep all discount values

            total += (arti.getSellingPrice() - discount); //Keep total price

            subTotal += arti.getSellingPrice();
        }

        amountP =  Integer.parseInt(amountPaid.getText());

        tva = listArticles.get(0).getTVA();
        tvaValue = (int) ((total * tva)/100);
        System.out.println(tvaValue);
        //total = (total + tvaValue);

        System.out.println(total);
        total = total + cbTransport.getValue().getPrice();

        balance = amountP - total;
        System.out.println(balance);

        allAccountingTab.clear();

        allAccountingTab.add(total);
        allAccountingTab.add(subTotal);
        allAccountingTab.add(allDiscount);
        allAccountingTab.add(allRefund);
        allAccountingTab.add(cbTransport.getValue().getPrice());
        allAccountingTab.add(tva);
        allAccountingTab.add(tvaValue);
        allAccountingTab.add(amountP);
        allAccountingTab.add(balance);

        return allAccountingTab;

    }

    public void transfertEmpInfos(Object[] obj){
        employeeInformations = (Employee) obj[0];
        employeeStore.addAll((List) obj[1]);

        footerUserName.setText(employeeInformations.getFirstName()+" "+employeeInformations.getLastName());
        footerStoreLocation.setText(employeeStore.get(0).getAddress() +" "+ employeeStore.get(0).getName().toUpperCase());

        System.out.println("USER LOADED !");
        //((Stage)search.getScene().getWindow()).setTitle("HOME | " + employeeStore.get(0).getAddress());
    }

    @FXML
    private void information(String heading, String body){
        BoxBlur blur = new BoxBlur(3,3,3);

        JFXDialogLayout dialogLayout = new JFXDialogLayout();

        JFXButton btn = new JFXButton("Okay");
        btn.setStyle("-fx-font-family: Tahoma;-fx-border-color: #919191; -fx-text-fill: #919191; -fx-cursor: hand; -fx-font-size: 12; -fx-pref-width: 80");

        JFXDialog dialog = new JFXDialog(rootSPane, dialogLayout, JFXDialog.DialogTransition.TOP);
        btn.setOnAction((actionEvent) -> dialog.close());

        dialogLayout.setHeading(new Label(heading));
        dialogLayout.setBody(new Text(body));
        dialogLayout.setActions(btn);

        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> rootPane.setEffect(null));
        rootPane.setEffect(blur);
    }

    private void information2(String title, String msg){
        TrayNotification tray = new TrayNotification();

        tray.setAnimationType(AnimationType.POPUP);
        tray.setTitle("BILL");
        tray.setMessage("The bill of ESSOH Lippe have been printed successfully");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
    }

    @FXML
    public void searchArticle(){

        //int num = search.getText().length();
        String sch = search.getText().toUpperCase().trim().replace(" ","");

        int num = sch.length();

        System.out.println(sch + " NUM = " + num);

        lblDiscount.setVisible(false);


        if(num > 0){
            valMsg.setVisible(true);
            if (num<8){
                valMsg.setText("The serial number remains " + (8 - num) + " character(s).");
                valMsg.setStyle("-fx-text-fill: rgb(235,100,0)");
                System.out.println("The serial number remains " + (8 - num) + " characters.");
                search.setStyle("-fx-border-color: rgb(235,100,0)");

                articleFound = null;
            }
            else if (num>8){
                valMsg.setText("The serial number has " + ((-1)*(8 - num)) + " extra character(s).");
                valMsg.setStyle("-fx-text-fill: rgb(210,0,0)");
                System.out.println("Try again please ! " + (8 - num));
                search.setStyle("-fx-border-color: rgb(210,0,0)");

                articleFound = null;

            }
            else {

                articleFound = supController.getArticle(sch);

                if(articleFound != null){
                    valMsg.setVisible(false);

                    search.setStyle("-fx-border-color: rgba(0,190,0)");

                    qtyRefund0.setText(String.valueOf(articleFound.getCategory().getSurplusCount()));
                    Refund0.setText("-" + String.valueOf(articleFound.getCategory().getSurplus()) + "%");
                    catName.setText(articleFound.getCategory().getName());
                    serialNumber.setText(articleFound.getSerialNumber());
                    modelName.setText(articleFound.getModelName());
                    price.setText(String.valueOf(articleFound.getSellingPrice()));

                    if ((int) articleFound.getDiscount() != 0){
                        lblDiscount.setVisible(true);
                        lblDiscount.setText("-"+String.valueOf((int) articleFound.getDiscount())+"%");
                    }

                    manufactury.setText(articleFound.getManufactury().getName());

                    btnAddBill.setDisable(false);

                }else {
                    valMsg.setText("Serial number not found !");
                    valMsg.setStyle("-fx-text-fill: rgb(105,105,105)");
                    System.out.println("Serial number not found !");
                    search.setStyle("-fx-border-color: rgba(105,105,105)");
                }

            }
        }else {
            valMsg.setVisible(false);
            search.setStyle(null);
        }

    }

    @FXML
    public void billPreviewTransport(){
        System.out.println(totalPrw);
        totalPrw -= addTransportPrice;
        System.out.println(totalPrw);
        addTransportPrice = 0;
        addTransportPrice = cbTransport.getValue().getPrice();
        totalPrw += addTransportPrice;
        System.out.println(totalPrw);
        totalPreview.setText(String.valueOf(totalPrw));
    }

    @FXML
    public void billPreview(){

        if(!listArticles.contains(articleFound) && articleFound != null){

            listArticles.add(articleFound);

            liteArticleSize = listArticles.size();
            System.out.println(liteArticleSize);

            lbl.setText(String.valueOf(liteArticleSize));

            totalPrw = totalPrw + articleFound.getSellingPrice();
            totalPreview.setText(String.valueOf(totalPrw));

            //Filter by category int he bill preview
            filterCategory(articleFound.getCategory().getName());

            btnAddBill.setDisable(true);
            clearArticleFound();

            ShowBillPreview();
        }
        else {
            information("Warning","This article is already added . ");
        }

    }

    @FXML
    public void quickSell(){

        if(!listArticles.contains(articleFound) && articleFound != null){

            listArticles.add(articleFound);

            btnAddBill.setDisable(true);
            clearArticleFound();
            Billed();
        }
        else {
            information("Warning","This article is already added . ");
        }

    }

    private void clearArticleFound(){

    }

    private void filterCategory(String category){
        String n = category.toLowerCase();
        System.out.println(n);
        switch (n)
        {
            case "laptop":
                lbl1.setText(String.valueOf(Integer.valueOf(lbl1.getText()) + 1));
                lbl1.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl1.setOpacity(1);
                img1.setOpacity(1);
                break;
            case "tablet":
                lbl2.setText(String.valueOf(Integer.valueOf(lbl2.getText()) + 1));
                lbl2.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl2.setOpacity(1);
                img2.setOpacity(1);
                break;
            case "desktop":
                lbl3.setText(String.valueOf(Integer.valueOf(lbl3.getText()) + 1));
                lbl3.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl3.setOpacity(1);
                img3.setOpacity(1);
                break;
            case "monitor":
                lbl4.setText(String.valueOf(Integer.valueOf(lbl4.getText()) + 1));
                lbl4.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl4.setOpacity(1);
                img4.setOpacity(1);
                break;
            case "central unit":
                lbl5.setText(String.valueOf(Integer.valueOf(lbl5.getText()) + 1));
                lbl5.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl5.setOpacity(1);
                img5.setOpacity(1);
                break;
            case "keyboard":
                lbl6.setText(String.valueOf(Integer.valueOf(lbl6.getText()) + 1));
                lbl6.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl6.setOpacity(1);
                img6.setOpacity(1);
                break;
            case "mouse":
                lbl7.setText(String.valueOf(Integer.valueOf(lbl7.getText()) + 1));
                lbl7.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl7.setOpacity(1);
                img7.setOpacity(1);
                break;
            case "scanner":
                lbl8.setText(String.valueOf(Integer.valueOf(lbl8.getText()) + 1));
                lbl8.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl8.setOpacity(1);
                img8.setOpacity(1);
                break;
            default :
                lbl9.setText(String.valueOf(Integer.valueOf(lbl9.getText()) + 1));
                lbl9.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #00004c");
                lbl9.setOpacity(1);
                img9.setOpacity(1);
        }
    }

    @FXML
    public void Billed(){
        //Full view of bill
        System.out.println("Full view of bill");

        rootPane.setEffect(new BoxBlur(2,2,3));
        rootPane1.setVisible(true);
        Bill.setVisible(true);
        User.setVisible(false);


        storeName.setText(employeeStore.get(0).getName());
        storeAddress.setText(employeeStore.get(0).getAddress());
        storeNumber.setText(String.valueOf(employeeStore.get(0).getPhoneNumber()));
        storeEmail.setText(employeeStore.get(0).getEmail());

        cusFirstNames.setText(cbCustomer.getValue().getFirstName());
        cusLastName.setText(cbCustomer.getValue().getLastName());
        cusNumber.setText(String.valueOf(cbCustomer.getValue().getPhoneNumber()));
        cusAddress.setText(cbCustomer.getValue().getAddress());

        empName.setText(employeeInformations.getFirstName()+"\n"+employeeInformations.getLastName());

        sellingDate.setText(new DateController().getShortDate());
        billNumber.setText(String.valueOf(employeeStore.get(0).getId()));

        loadArticles();  //Loading the bill table

        //Loading of all bill values

        billTotal1.setText(String.valueOf(accounting().get(0)));
        billTotal2.setText(String.valueOf(accounting().get(0)));
        billSubTotal.setText(String.valueOf(accounting().get(1)));
        billDiscountValue.setText(String.valueOf(accounting().get(2)));
        billRefund.setText(String.valueOf(accounting().get(3)));
        billTransport.setText(String.valueOf(accounting().get(4)));
        billTVA.setText(String.valueOf(accounting().get(5)));
        billTVAValue.setText(String.valueOf(accounting().get(6)));
        billPaid.setText(String.valueOf(accounting().get(7)));
        billBalance.setText(String.valueOf(accounting().get(8)));

    }

    @FXML
    private void testingAmount(KeyEvent keyEvent){
       char a = keyEvent.getKeyChar();
        System.out.println("Checking 1");
       if (!(Character.isDigit(a) && (a == KeyEvent.VK_BACK_SPACE))){
           System.out.println("Checking 2");
           keyEvent.consume();
       }

    }

    @FXML
    public void cancelBill(){
        rootPane.setEffect(null);
        rootPane1.setVisible(false);
        Bill.setVisible(false);
        User.setVisible(false);

        listArticles.clear();
        artsList.clear();
        lbl.setText("0");
        totalPreview.setText("0");
        totalPrw = 0;
        amountPaid.setText("0");

        lbl1.setText("0");
        lbl1.setStyle("-fx-background-color: DarkGray");
        lbl1.setOpacity(0.4);
        img1.setOpacity(0.4);

        lbl2.setText("0");
        lbl2.setStyle("-fx-background-color: DarkGray");
        lbl2.setOpacity(0.4);
        img2.setOpacity(0.4);

        lbl3.setText("0");
        lbl3.setStyle("-fx-background-color: DarkGray");
        lbl3.setOpacity(0.4);
        img3.setOpacity(0.4);

        lbl3.setText("0");
        lbl3.setStyle("-fx-background-color: DarkGray");
        lbl3.setOpacity(0.4);
        img3.setOpacity(0.4);

        lbl4.setText("0");
        lbl4.setStyle("-fx-background-color: DarkGray");
        lbl4.setOpacity(0.4);
        img4.setOpacity(0.4);

        lbl5.setText("0");
        lbl5.setStyle("-fx-background-color: DarkGray");
        lbl5.setOpacity(0.4);
        img5.setOpacity(0.4);

        lbl6.setText("0");
        lbl6.setStyle("-fx-background-color: DarkGray");
        lbl6.setOpacity(0.4);
        img6.setOpacity(0.4);

        lbl7.setText("0");
        lbl7.setStyle("-fx-background-color: DarkGray");
        lbl7.setOpacity(0.4);
        img7.setOpacity(0.4);

        lbl8.setText("0");
        lbl8.setStyle("-fx-background-color: DarkGray");
        lbl8.setOpacity(0.4);
        img8.setOpacity(0.4);

        lbl9.setText("0");
        lbl9.setStyle("-fx-background-color: DarkGray");
        lbl9.setOpacity(0.4);
        img9.setOpacity(0.4);

        cbTransport.getSelectionModel().selectFirst();
        cbCustomer.getSelectionModel().clearSelection();
    }

    @FXML
    public void createBill(){

        int total = (int) allAccountingTab.get(0);
        Bill bill = new Bill(cbCustomer.getValue(),employeeInformations,cbTransport.getValue(),
                Integer.parseInt(amountPaid.getText()),total);

        supController.setBill(bill, listArticles);

        cancelBill();

        //information("Information", "The bill have been created successfully !");

        information2("BILL", "The bill of " + cbCustomer.getValue() + " have been printed successfully");

        AllFirstLoadArticles();
    }

    public static class ArticleClassTab {
        private final SimpleStringProperty serialN;
        private final SimpleStringProperty articlesN;
        private final SimpleIntegerProperty price;

        ArticleClassTab(String serialN, String articlesN, Integer price) {
            this.serialN = new SimpleStringProperty(serialN);
            this.articlesN = new SimpleStringProperty(articlesN);
            this.price = new SimpleIntegerProperty(price);
        }

        public String getSerialN() {
            return serialN.get();
        }

        public String getArticlesN() {
            return articlesN.get();
        }

        public int getPrice() {
            return price.get();
        }
    }

    private void initCol(){
        // initiated table column in bill
        System.out.println("initiated table column");

        serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialN"));
        articleNamesCol.setCellValueFactory(new PropertyValueFactory<>("articlesN"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void loadArticles(){
        //Loading table in bill
        System.out.println("Loading bill table");

        for (int i = 0; i <= listArticles.size() - 1; i++){
            Article ar = listArticles.get(i);

            System.out.println(ar.getModelName());
            ArticleClassTab billart = new ArticleClassTab(
                    ar.getSerialNumber()
                    , ar.getManufactury().getName() + " " + ar.getModelName()
                    ,ar.getSellingPrice()
            );

            artsList.add(billart);
        }
        articlesTable.getItems().setAll(artsList);
    }

    @FXML
    public void home(){
        bodyHome.setVisible(true);
        bodyArticles.setVisible(false);
        bodyCustomer.setVisible(false);
        bodyBill.setVisible(false);
        bodyBalanceSheet.setVisible(false);


        if (tagPane.getTranslateX() > 71){
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), tagPane);
            transition.setToX(0);
            transition.play();
            tagPane.setWidth(110);
        }
        System.out.println(tagPane.getTranslateX());

/*
        if(tagPane.getTranslateX()>0){
            tagPane.setWidth(110);
            while (tagPane.getTranslateX()>0){
                tagPane.setTranslateX(tagPane.getTranslateX() - 1);
            }
        }
        */
    }

    //Load combo box

    @FXML
    public void loadCust(){
        ObservableList<Customer> costList = supController.getCustomer();

        System.out.println(costList.toString());
        cbCustomer.getItems().addAll(costList);
        cbCustomer.setPromptText("Customer");

    }

    @FXML
    public void loadTrans(){
        ObservableList<Transport> transList = supController.getTransport();

        cbTransport.getItems().addAll(transList);
        cbTransport.getSelectionModel().selectFirst();
        //cbTransport.setPromptText("Transport");
    }

    // List of articles script

    public static class AllArticleClassTab{
        private final SimpleStringProperty serialNumber;
        private final SimpleStringProperty manufacturyName;
        private final SimpleStringProperty modelName;
        private final SimpleStringProperty categoryName;
        private final SimpleIntegerProperty Price;

        private AllArticleClassTab(String serialNumber, String manufacturyName, String modelName, String categoryName, Integer price) {
            this.serialNumber = new SimpleStringProperty(serialNumber);
            this.manufacturyName = new SimpleStringProperty(manufacturyName);
            this.modelName = new SimpleStringProperty(modelName);
            this.categoryName = new SimpleStringProperty(categoryName);
            this.Price = new SimpleIntegerProperty(price);
        }

        public String getSerialNumber() {
            return serialNumber.get();
        }

        public String getManufacturyName() {
            return manufacturyName.get();
        }

        public String getModelName() {
            return modelName.get();
        }

        public String getCategoryName() {
            return categoryName.get();
        }

        public int getPrice() {
            return Price.get();
        }
    }

    private void initColArticle(){
        allSerialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        allManufacturyNameCol.setCellValueFactory(new PropertyValueFactory<>("manufacturyName"));
        allModelNameCol.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        allCategoryNameCol.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        allPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }

    @FXML
    public void AllLoadArticles(){

        // Set the visibility of anchors

        bodyHome.setVisible(false);
        bodyArticles.setVisible(true);
        bodyCustomer.setVisible(false);
        bodyBill.setVisible(false);
        bodyBalanceSheet.setVisible(false);


        if(tagPane.getTranslateX() != 122){
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), tagPane);
            transition.setToX(122);
            transition.play();
        }
        tagPane.setWidth(100);
        System.out.println(tagPane.getTranslateX());


        /*TapPanel move from Articles List
        double Now = tagPane.getTranslateX();
        if (Now-122<0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=122){
                tagPane.setTranslateX(tagPane.getTranslateX() + 1);
            }
        }else if (Now-193>0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=122){
                //tagPane.setTranslateX(tagPane.getTranslateX() - 1);
                transition.setToX(tagPane.getTranslateX() - 1);
                transition.play();
            }
        }
*/
    }

    private void AllFirstLoadArticles(){

        //Clear Articles Table before loading
        allArtsList.clear();
        int count = supController.getAllArticle().size();
        for (int i = 0; i <= count - 1; i++){
            System.out.println(supController.getAllArticle().get(i).getSerialNumber());
            Article ar = supController.getAllArticle().get(i);

            AllArticleClassTab allArt = new AllArticleClassTab(ar.getSerialNumber(),ar.getManufactury().getName(),ar.getModelName(),ar.getCategory().getName(),ar.getRealSellingPrice());
            allArtsList.add(allArt);
        }
        AllArticlesTable.getItems().setAll(allArtsList);
        countArticle.setText(count + " Customer(s) have been register");

    }

    //List of Customers Script
    @FXML
    public void AllLoadCustomers(){

        bodyHome.setVisible(false);
        bodyArticles.setVisible(false);
        bodyCustomer.setVisible(true);
        bodyBill.setVisible(false);
        bodyBalanceSheet.setVisible(false);


        if(tagPane.getTranslateX() != 222) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), tagPane);
            transition.setToX(222);
            transition.play();
        }
        tagPane.setWidth(100);
        System.out.println(tagPane.getTranslateX());
/*
        //TapPanel move from Articles List
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), tagPane);
        double Now = tagPane.getTranslateX();
        if (Now-222<0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=222){
                //tagPane.setTranslateX(tagPane.getTranslateX() + 1);
                transition.setToX(tagPane.getTranslateX() + 1);
                transition.play();
            }
        }else if (Now-222>0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=222){
                //tagPane.setTranslateX(tagPane.getTranslateX() - 1);
                transition.setToX(tagPane.getTranslateX() - 1);
                transition.play();
            }
        }
        */
    }

    @FXML
    public void addCustPane(){

        rootPane.setEffect(new BoxBlur(2,2,3));
        rootPane1.setVisible(true);
        Bill.setVisible(false);
        User.setVisible(true);

    }

    @FXML
    public void cancelAddCustPane(){

        rootPane.setEffect(null);
        rootPane1.setVisible(false);
        Bill.setVisible(false);
        User.setVisible(false);

        newCustFName.setText("");
        newCustLName.setText("");
        newCustPhone.setText("");
        newCustAddress.setText("");
        newCustEmail.setText("");
        newCustGenderF.setSelected(false);
        newCustGenderM.setSelected(false);
        newCustPicture.setText("");
        newCustPictureV.setText("Choose customer's picture");

        File file = new File("C:/Users/FUTURE COMPUTER/IdeaProjects/ComputerShop/src/computer/imgPerson/user-male-icon.png");
        Image imgC = new Image(file.toURI().toString(),200, 233, true, true);
        newCustPicture0.setImage(imgC);


    }

    @FXML
    public void addNewCustomer(){
        String gender;

        if (newCustGenderM.isSelected()) {
            gender = "Male";
        } else if (newCustGenderF.isSelected()) {
            gender = "Female";
        } else {
            gender = "";
        }

        if (newCustFName.getText().isEmpty() || newCustLName.getText().isEmpty() || newCustPhone.getText().isEmpty()
                || newCustAddress.getText().isEmpty() || newCustEmail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter in all fields !");
            alert.showAndWait();
            return;
        }

        if (gender.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please check your gender !");
            alert.showAndWait();
            return;
        }

        if (newCustPicture.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the image !");
            alert.showAndWait();
            return;
        }

        Customer customer = new Customer(newCustFName.getText(), newCustLName.getText(),
                gender, Integer.valueOf(newCustPhone.getText()), newCustEmail.getText(), newCustPicture.getText(), newCustAddress.getText());

        if (supController.setCustomerIsAdded(customer)){
            information("Warning", "The user is already added !");
        } else {
            supController.setCustomer(customer);
            information("Information", "User added successfully !");
        }

        cancelAddCustPane();

    }


    @FXML
    public void imgs() {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            System.out.println(file);
            System.out.println(file.toURI().toString());
            newCustPicture.setText(file.getAbsolutePath());
            newCustPictureV.setText(file.getAbsolutePath());

            Image img = new Image(file.toURI().toString(), 200, 233, true, true);
            newCustPicture0.setImage(img);
            //image = new ImageView(img);
            newCustPicture0.setPreserveRatio(true);

        }
    }

    //List of Bills Script
    @FXML
    public void AllLoadBills(){
        bodyHome.setVisible(false);
        bodyArticles.setVisible(false);
        bodyCustomer.setVisible(false);
        bodyBill.setVisible(true);
        bodyBalanceSheet.setVisible(false);

        System.out.println(tagPane.getTranslateX());

        if(tagPane.getTranslateX() != 322){
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), tagPane);
            transition.setToX(322);
            transition.play();
        }
        tagPane.setWidth(100);


        /*
        //TapPanel move from Articles List
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), tagPane);
        double Now = tagPane.getTranslateX();
        if (Now-322<0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=322){
                //tagPane.setTranslateX(tagPane.getTranslateX() + 1);
                transition.setToX(tagPane.getTranslateX() + 1);
                transition.play();
            }
        }else if (Now-322>0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=322){
                //tagPane.setTranslateX(tagPane.getTranslateX() - 1);
                transition.setToX(tagPane.getTranslateX() - 1);
                transition.play();
            }
        }
        */
    }

    //Balance sheet
    @FXML
    public void BalanceSheet(){
        bodyHome.setVisible(false);
        bodyArticles.setVisible(false);
        bodyCustomer.setVisible(false);
        bodyBill.setVisible(false);
        bodyBalanceSheet.setVisible(true);

        System.out.println(tagPane.getTranslateX());

        if(tagPane.getTranslateX() != 422){
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), tagPane);
            transition.setToX(422);
            transition.play();
        }
        tagPane.setWidth(100);

        /*
        //TapPanel move from Articles List
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), tagPane);
        double Now = tagPane.getTranslateX();
        if (Now-422<0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=422){
                //tagPane.setTranslateX(tagPane.getTranslateX() + 1);
                transition.setToX(tagPane.getTranslateX() + 1);
                transition.play();
            }
        }else if (Now-422>0){
            tagPane.setWidth(100);
            while (tagPane.getTranslateX()!=422){
                //tagPane.setTranslateX(tagPane.getTranslateX() - 1);
                transition.setToX(tagPane.getTranslateX() - 1);
                transition.play();
            }
        }
        */
    }

    //About
    @FXML
    public void aboutUs() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/computer/ui/employee/manageArticle/manageArticle.fxml"));
            Parent root = loader.load();
            /*
            homeController homeContro = loader.getController();
            homeContro.transfertEmpInfos(emp);
            */
            Stage stage = new Stage();
            stage.setTitle("Balance sheet");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 1200, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Show billPreviewPane Pane
    @FXML
    public void ShowBillPreview(){
        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(0.2), view1);
        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(0.4), billPreviewPane);

        System.out.println(view1.getTranslateY());

        if (view1.getTranslateY() != -48){
            transition1.setToY(- 48);
            transition1.play();

            transition2.setToX(1035 + 86);
            transition2.play();
        }else if (view1.getTranslateY() != 0){
            transition1.setToY(0);
            transition1.play();

            transition2.setToX(0);
            transition2.play();
        }

    }
}