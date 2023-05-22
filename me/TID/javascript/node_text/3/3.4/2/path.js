const path = require('path');

const string = __filename;

console.log('path.sep:', path.sep);
console.log('path.delemiter:', path.delimiter);
console.log('----------------------------------------------------------------')
console.log('path.dirname:', path.dirname(string));
console.log('path.extname:', path.extname(string));
console.log('path.basename:', path.basename(string));
console.log('path.bassename - extname:',path.basename(string, path.extname(string)));
console.log('----------------------------------------------------------------')
console.log('path.parse:', path.parse(string));
console.log('path.format:',path.format({
    dir: 'c\\user\\hongsuk',
    name: 'path',
    ext:'.js'
}))
console.log('path.normalize:', path.normalize('c:\\user\\hongsuk\\\path.js'));
console.log('-------------------------------------------------------------------')
console.log('path.isAbsolute:', path.isAbsolute('c:\\'));
console.log('path.isAbsolute(./home):', path.isAbsolute('./home'));
console.log('---------------------------------------------------------------------')
console.log('path.relative:', path.relative('c:\\user\\hongsuk', 'c:\\user\\'));