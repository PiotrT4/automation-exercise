package helpers;

public class FilePathData {
    public final String downloadFilesDirectoryPath;
    public final String invoiceFileName;

    public FilePathData(TestDataReader testDataReader) {
        this.downloadFilesDirectoryPath = testDataReader.getDownloadFilesDirectoryPath();
        this.invoiceFileName = testDataReader.getInvoiceFileName();
    }
}
