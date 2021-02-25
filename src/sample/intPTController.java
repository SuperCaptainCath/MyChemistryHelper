package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class intPTController {

    //Fields in the information box about the element
    @FXML private Text elementSymbolText;
    @FXML private Text elementNameText;
    @FXML private Text elementAtomicNumText;
    @FXML private Text elementAtomicMassText;
    @FXML private Text elementMeltPtText;
    @FXML private Text elementBoilPtText;

    //The rectangles of each element, will be used as buttons
    @FXML private Rectangle buttonH1;

    @FXML private ToggleButton b1;
    @FXML private ToggleButton b2;
    @FXML private ToggleButton b3;
    @FXML private ToggleButton b4;
    @FXML private ToggleButton b5;
    @FXML private ToggleButton b6;
    @FXML private ToggleButton b7;
    @FXML private ToggleButton b8;

    //mouseEvent for each element
    public void clickedH1(MouseEvent mouseEvent) throws IOException {
        displayElement(0);
        b1.setSelected(true);
    }
    public void clickedHe2(MouseEvent mouseEvent) throws IOException {
        displayElement(1);
        b2.setSelected(true);
    }
    public void clickedLi3(MouseEvent mouseEvent) throws IOException {
        displayElement(2);
        b3.setSelected(true);
    }
    public void clickedBe4(MouseEvent mouseEvent) throws IOException {
        displayElement(3);
        b4.setSelected(true);
    }
    public void clickedB5(MouseEvent mouseEvent) throws IOException {
        displayElement(4);
        b5.setSelected(true);
    }
    public void clickedC6(MouseEvent mouseEvent) throws IOException {
        displayElement(5);
        b6.setSelected(true);
    }
    public void clickedN7(MouseEvent mouseEvent) throws IOException {
        displayElement(6);
        b7.setSelected(true);
    }
    public void clickedO8(MouseEvent mouseEvent) throws IOException {
        displayElement(7);
    }
    public void clickedF9(MouseEvent mouseEvent) throws IOException {
        displayElement(8);
    }
    public void clickedNe10(MouseEvent mouseEvent) throws IOException {
        displayElement(9);
    }
    public void clickedNa11(MouseEvent mouseEvent) throws IOException {
        displayElement(10);
    }
    public void clickedMg12(MouseEvent mouseEvent) throws IOException {
        displayElement(11);
    }
    public void clickedAl13(MouseEvent mouseEvent) throws IOException {
        displayElement(12);
    }
    public void clickedSi14(MouseEvent mouseEvent) throws IOException {
        displayElement(13);
    }
    public void clickedP15(MouseEvent mouseEvent) throws IOException {
        displayElement(14);
    }
    public void clickedS16(MouseEvent mouseEvent) throws IOException {
        displayElement(15);
    }
    public void clickedCl17(MouseEvent mouseEvent) throws IOException {
        displayElement(16);
    }
    public void clickedAr18(MouseEvent mouseEvent) throws IOException {
        displayElement(17);
    }
    public void clickedK19(MouseEvent mouseEvent) throws IOException {
        displayElement(18);
    }
    public void clickedCa20(MouseEvent mouseEvent) throws IOException {
        displayElement(19);
    }
    public void clickedSc21(MouseEvent mouseEvent) throws IOException {
        displayElement(20);
    }
    public void clickedTi22(MouseEvent mouseEvent) throws IOException {
        displayElement(21);
    }
    public void clickedV23(MouseEvent mouseEvent) throws IOException {
        displayElement(22);
    }
    public void clickedCr24(MouseEvent mouseEvent) throws IOException {
        displayElement(23);
    }
    public void clickedMn25(MouseEvent mouseEvent) throws IOException {
        displayElement(24);
    }
    public void clickedFe26(MouseEvent mouseEvent) throws IOException {
        displayElement(25);
    }
    public void clickedCo27(MouseEvent mouseEvent) throws IOException {
        displayElement(26);
    }
    public void clickedNi28(MouseEvent mouseEvent) throws IOException {
        displayElement(27);
    }
    public void clickedCu29(MouseEvent mouseEvent) throws IOException {
        displayElement(28);
    }
    public void clickedZn30(MouseEvent mouseEvent) throws IOException {
        displayElement(29);
    }
    public void clickedGa31(MouseEvent mouseEvent) throws IOException {
        displayElement(30);
    }
    public void clickedGe32(MouseEvent mouseEvent) throws IOException {
        displayElement(31);
    }
    public void clickedAs33(MouseEvent mouseEvent) throws IOException {
        displayElement(32);
    }
    public void clickedSe34(MouseEvent mouseEvent) throws IOException {
        displayElement(33);
    }
    public void clickedBr35(MouseEvent mouseEvent) throws IOException {
        displayElement(34);
    }
    public void clickedKr36(MouseEvent mouseEvent) throws IOException {
        displayElement(35);
    }
    public void clickedRb37(MouseEvent mouseEvent) throws IOException {
        displayElement(36);
    }
    public void clickedSr38(MouseEvent mouseEvent) throws IOException {
        displayElement(37);
    }
    public void clickedY39(MouseEvent mouseEvent) throws IOException {
        displayElement(38);
    }
    public void clickedZr40(MouseEvent mouseEvent) throws IOException {
        displayElement(39);
    }
    public void clickedNb41(MouseEvent mouseEvent) throws IOException {
        displayElement(40);
    }
    public void clickedMo42(MouseEvent mouseEvent) throws IOException {
        displayElement(41);
    }
    public void clickedTc43(MouseEvent mouseEvent) throws IOException {
        displayElement(42);
    }
    public void clickedRu44(MouseEvent mouseEvent) throws IOException {
        displayElement(43);
    }
    public void clickedRh45(MouseEvent mouseEvent) throws IOException {
        displayElement(44);
    }
    public void clickedPd46(MouseEvent mouseEvent) throws IOException {
        displayElement(45);
    }
    public void clickedAg47(MouseEvent mouseEvent) throws IOException {
        displayElement(46);
    }
    public void clickedCd48(MouseEvent mouseEvent) throws IOException {
        displayElement(47);
    }
    public void clickedIn49(MouseEvent mouseEvent) throws IOException {
        displayElement(48);
    }
    public void clickedSn50(MouseEvent mouseEvent) throws IOException {
        displayElement(49);
    }
    public void clickedSb51(MouseEvent mouseEvent) throws IOException {
        displayElement(50);
    }
    public void clickedTe52(MouseEvent mouseEvent) throws IOException {
        displayElement(51);
    }
    public void clickedI53(MouseEvent mouseEvent) throws IOException {
        displayElement(52);
    }
    public void clickedXe54(MouseEvent mouseEvent) throws IOException {
        displayElement(53);
    }
    public void clickedCs55(MouseEvent mouseEvent) throws IOException {
        displayElement(54);
    }
    public void clickedBa56(MouseEvent mouseEvent) throws IOException {
        displayElement(55);
    }
    public void clickedLa57(MouseEvent mouseEvent) throws IOException {
        displayElement(56);
    }
    public void clickedCe58(MouseEvent mouseEvent) throws IOException {
        displayElement(57);
    }
    public void clickedPr59(MouseEvent mouseEvent) throws IOException {
        displayElement(58);
    }
    public void clickedNd60(MouseEvent mouseEvent) throws IOException {
        displayElement(59);
    }
    public void clickedPm61(MouseEvent mouseEvent) throws IOException {
        displayElement(60);
    }
    public void clickedSm62(MouseEvent mouseEvent) throws IOException {
        displayElement(61);
    }
    public void clickedEu63(MouseEvent mouseEvent) throws IOException {
        displayElement(62);
    }
    public void clickedGd64(MouseEvent mouseEvent) throws IOException {
        displayElement(63);
    }
    public void clickedTb65(MouseEvent mouseEvent) throws IOException {
        displayElement(64);
    }
    public void clickedDy66(MouseEvent mouseEvent) throws IOException {
        displayElement(65);
    }
    public void clickedHo67(MouseEvent mouseEvent) throws IOException {
        displayElement(66);
    }
    public void clickedEr68(MouseEvent mouseEvent) throws IOException {
        displayElement(67);
    }
    public void clickedTm69(MouseEvent mouseEvent) throws IOException {
        displayElement(68);
    }
    public void clickedYb70(MouseEvent mouseEvent) throws IOException {
        displayElement(69);
    }
    public void clickedLu71(MouseEvent mouseEvent) throws IOException {
        displayElement(70);
    }
    public void clickedHf72(MouseEvent mouseEvent) throws IOException {
        displayElement(71);
    }
    public void clickedTa73(MouseEvent mouseEvent) throws IOException {
        displayElement(72);
    }
    public void clickedW74(MouseEvent mouseEvent) throws IOException {
        displayElement(73);
    }
    public void clickedRe75(MouseEvent mouseEvent) throws IOException {
        displayElement(74);
    }
    public void clickedOs76(MouseEvent mouseEvent) throws IOException {
        displayElement(75);
    }
    public void clickedIr77(MouseEvent mouseEvent) throws IOException {
        displayElement(76);
    }
    public void clickedPt78(MouseEvent mouseEvent) throws IOException {
        displayElement(77);
    }
    public void clickedAu79(MouseEvent mouseEvent) throws IOException {
        displayElement(78);
    }
    public void clickedHg80(MouseEvent mouseEvent) throws IOException {
        displayElement(79);
    }
    public void clickedTi81(MouseEvent mouseEvent) throws IOException {
        displayElement(80);
    }
    public void clickedPb82(MouseEvent mouseEvent) throws IOException {
        displayElement(81);
    }
    public void clickedBi83(MouseEvent mouseEvent) throws IOException {
        displayElement(82);
    }
    public void clickedPo84(MouseEvent mouseEvent) throws IOException {
        displayElement(83);
    }
    public void clickedAt85(MouseEvent mouseEvent) throws IOException {
        displayElement(84);
    }
    public void clickedRn86(MouseEvent mouseEvent) throws IOException {
        displayElement(85);
    }
    public void clickedFr87(MouseEvent mouseEvent) throws IOException {
        displayElement(86);
    }
    public void clickedRa88(MouseEvent mouseEvent) throws IOException {
        displayElement(87);
    }
    public void clickedAc89(MouseEvent mouseEvent) throws IOException {
        displayElement(88);
    }
    public void clickedTh90(MouseEvent mouseEvent) throws IOException {
        displayElement(89);
    }
    public void clickedPa91(MouseEvent mouseEvent) throws IOException {
        displayElement(90);
    }
    public void clickedU92(MouseEvent mouseEvent) throws IOException {
        displayElement(91);
    }
    public void clickedNp93(MouseEvent mouseEvent) throws IOException {
        displayElement(92);
    }
    public void clickedPu94(MouseEvent mouseEvent) throws IOException {
        displayElement(93);
    }
    public void clickedAm95(MouseEvent mouseEvent) throws IOException {
        displayElement(94);
    }
    public void clickedCm96(MouseEvent mouseEvent) throws IOException {
        displayElement(95);
    }
    public void clickedBk97(MouseEvent mouseEvent) throws IOException {
        displayElement(96);
    }
    public void clickedCf98(MouseEvent mouseEvent) throws IOException {
        displayElement(97);
    }
    public void clickedEs99(MouseEvent mouseEvent) throws IOException {
        displayElement(98);
    }
    public void clickedFm100(MouseEvent mouseEvent) throws IOException {
        displayElement(99);
    }
    public void clickedMd101(MouseEvent mouseEvent) throws IOException {
        displayElement(100);
    }
    public void clickedNo102(MouseEvent mouseEvent) throws IOException {
        displayElement(101);
    }
    public void clickedLr103(MouseEvent mouseEvent) throws IOException {
        displayElement(102);
    }
    public void clickedRf104(MouseEvent mouseEvent) throws IOException {
        displayElement(103);
    }
    public void clickedDb105(MouseEvent mouseEvent) throws IOException {
        displayElement(104);
    }
    public void clickedSg106(MouseEvent mouseEvent) throws IOException {
        displayElement(105);
    }
    public void clickedBh107(MouseEvent mouseEvent) throws IOException {
        displayElement(106);
    }
    public void clickedHs108(MouseEvent mouseEvent) throws IOException {
        displayElement(107);
    }
    public void clickedMt109(MouseEvent mouseEvent) throws IOException {
        displayElement(108);
    }
    public void clickedDs110(MouseEvent mouseEvent) throws IOException {
        displayElement(109);
    }
    public void clickedRg111(MouseEvent mouseEvent) throws IOException {
        displayElement(110);
    }
    public void clickedCn112(MouseEvent mouseEvent) throws IOException {
        displayElement(111);
    }
    public void clickedNh113(MouseEvent mouseEvent) throws IOException {
        displayElement(112);
    }
    public void clickedFl114(MouseEvent mouseEvent) throws IOException {
        displayElement(113);
    }
    public void clickedMc115(MouseEvent mouseEvent) throws IOException {
        displayElement(114);
    }
    public void clickedLv116(MouseEvent mouseEvent) throws IOException {
        displayElement(115);
    }
    public void clickedTs117(MouseEvent mouseEvent) throws IOException {
        displayElement(116);
    }
    public void clickedOg118(MouseEvent mouseEvent) throws IOException {
        displayElement(117);
    }

    //Method that displays the element's information into the information box
    public void displayElement (int index) throws IOException {
        String specificLineInfo = Files.readAllLines(Paths.get("src/resources/table.txt")).get(index);
        String[] splitLineInfo = specificLineInfo.split(",");

        elementAtomicNumText.setText(splitLineInfo[0]);
        elementSymbolText.setText(splitLineInfo[1]);
        elementNameText.setText(splitLineInfo[2]);
        elementAtomicMassText.setText(splitLineInfo[3]);

        //If there is no value, do not show units
        if (splitLineInfo[4].equals("Unknown"))
            elementMeltPtText.setText(splitLineInfo[4]);
        else
            elementMeltPtText.setText(splitLineInfo[4] + " K");

        if (splitLineInfo[5].equals("Unknown"))
            elementBoilPtText.setText(splitLineInfo[5]);
        else
            elementBoilPtText.setText(splitLineInfo[5] + " K");
    }
}
