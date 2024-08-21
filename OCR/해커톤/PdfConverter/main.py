import PdfConverter

path = "/Users/ijongsu/Desktop/Study/OCR/해커톤/kimseoyung.pdf"
pdfToText = PdfConverter.PdfToText(path)
print(pdfToText)