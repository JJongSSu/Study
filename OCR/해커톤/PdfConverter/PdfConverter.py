import fitz

def PdfToText(pdfPath):
    doc = fitz.open(pdfPath)
    text = ''
    for page in doc:
        text = page.get_text()
    return text

if __name__ == "__main__":
    text = PdfToText("/Users/ijongsu/Desktop/Study/OCR/해커톤/kimseoyung.pdf")
    print(text)