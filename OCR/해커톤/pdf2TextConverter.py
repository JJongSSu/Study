import os
from pathlib import Path
import PyPDF2
import pdfplumber
import traceback


class Pdf2TextConverter:
    txtExt = '.txt'
    
    def __init__(self):
        pass
    
    def convert(self, pdfFilePath, outputDir):
        try:
            if not os.path.exists(outputDir):
                os.makedirs(outputDir)
                
            path, pdfFilePath = os.path.split(pdfFilePath)
            pdfFileNameWithoutExt = Path(pdfFilePath).stem
            
            pageNumber = 0
            with open(pdfFilePath, 'rb') as pdfFile:
                pdfReader = PyPDF2.PdfFileReader(pdfFile)
                pageNumber = pdfReader.numPages
                
            textFilePathList = []
            with pdfplumber.open(pdfFilePath) as pdf:
                for i in range(pageNumber):
                    page = pdf.pages[i]
                    text = page.extract_text()
                    print(text)
                    
                    txtFileName = pdfFileNameWithoutExt + '-page-' + str(i).zfill(3) + self.txtExt
                    txtFilePath = outputDir + "\\" + txtFileName
                    
                    with open(txtFilePath, 'w', encoding='utf-8-sig') as txtFile:
                        txtFile.write(text)
                        
                    textFilePathList.append(txtFilePath)
                    
            return textFilePathList
        
        except Exception as e:
            raise(e)

def testPdf2TextConverter():
    try:
        pdfFileName = 'test.pdf'
        
        dataDir = os.getcwd() + '\\data'
        pdfFilePath = dataDir + "\\" + pdfFileName
        outputDir = dataDir + "\\" + Path(pdfFileName).stem + "\\text"
        
        pdf2TextConverter = Pdf2TextConverter()
        textFilePathList = pdf2TextConverter.convert(pdfFilePath, outputDir)
        
    except Exception as e:
        traceback.format_exc()
    
if __name__ == '__main__':
    testPdf2TextConverter()
    