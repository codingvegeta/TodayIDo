const a = true;
if (a) {
    const m1 = await import('../2/func.mjs');
    console.log(m1);
    const m2 = await import('../2/var.mjs');
    console.log(m2);
}