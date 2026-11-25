from pypdf import PdfReader
import glob, os, json
os.makedirs('graphify-out/pdftext', exist_ok=True)
report = []
for p in sorted(glob.glob('EC*.pdf')):
    r = PdfReader(p)
    txt = ''.join((pg.extract_text() or '') for pg in r.pages)
    out = 'graphify-out/pdftext/' + os.path.splitext(os.path.basename(p))[0] + '.txt'
    with open(out, 'w', encoding='utf-8') as f:
        f.write(txt)
    report.append({'file': out, 'pages': len(r.pages), 'chars': len(txt)})
with open('graphify-out/pdftext/report.json', 'w', encoding='utf-8') as f:
    json.dump(report, f, ensure_ascii=False, indent=2)