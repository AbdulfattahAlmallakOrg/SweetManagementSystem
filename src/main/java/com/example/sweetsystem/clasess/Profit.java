package com.example.sweetsystem.clasess;
/*import com.itextpdf.text. Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;*/

import java.util.List;
import static javafx.application.Application.launch;

public class Profit {
    private final List<Transaction> transactions;
    private double totalRevenue;
    private double totalExpenses;

    public Profit(List<Transaction> transactions) {
        this.transactions = transactions;
        this.totalRevenue = 0;
        this.totalExpenses = 0;
        calculateTotals(); // Calculate initial totals
    }

    public double calculateTotalRevenue() {
        return transactions.stream()
                .filter(Transaction::isRevenue)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateTotalExpenses() {
        return transactions.stream()
                .filter(transaction -> !transaction.isRevenue())
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateProfit() {
        return calculateTotalRevenue() - calculateTotalExpenses();
    }

    public void recordSale(Product product, int quantitySold) {
        double saleAmount = product.getPrice() * quantitySold;
        recordTransaction("Sale of product " + product.getName(), saleAmount, true);
    }

    public void recordTransaction(String description, double amount, boolean isRevenue) {
        Transaction transaction = new Transaction(description, amount, isRevenue);
        transactions.add(transaction);

        if (isRevenue) {
            totalRevenue += amount;
        } else {
            totalExpenses += amount;
        }
    }

    private void calculateTotals() {
        this.totalRevenue = calculateTotalRevenue();
        this.totalExpenses = calculateTotalExpenses();
    }

    public double getTotalProfit() {
        return calculateProfit();
    }
}


    /*  public void generatePdfReport(String filePath) throws DocumentException, IOException {
          Document document = new Document();
          PdfWriter.getInstance(document, new FileOutputStream(filePath));
          document.open();
          document.add(new Paragraph("Financial Report"));
          document.add(new Paragraph("================"));

          for (Transaction transaction : transactions) {
              document.add(new Paragraph(transaction.toString()));
          }

          document.add(new Paragraph("================"));
          document.add(new Paragraph("Total Revenue: " + calculateTotalRevenue()));
          document.add(new Paragraph("Total Expenses: " + calculateTotalExpenses()));
          document.add(new Paragraph("Total Profit: " + calculateProfit()));

          document.close();
      }
  */
