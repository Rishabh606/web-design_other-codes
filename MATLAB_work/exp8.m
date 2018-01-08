clc; 
clear all;
close all;
k=zeros(1,200);
for i=1:1:200
    sig=@(w) x1(w/(3)).*rect(w).*exp(1j*w*(i-100));
    k(i)=integral(sig,-20,20)/(2*pi);
end;
subplot(4,2,1);
t=linspace(-pi,pi,101);
plot(abs(k));
xlabel('USER-Defined');
subplot(4,2,2);
plot(t,fftshift(abs(ifft(x1(t/3).*rect(t)))));
xlabel('Inbuilt');
mat=zeros(1,4);
rix=[0 1 2 3];
for i=1:1:4
    for r=1:1:4
        mat(i)=mat(i)+rix(r).*exp(-2j*(pi/4)*(i-1)*(r-1));
    end;
end;
subplot(4,2,3);
disp(mat);
stem(((mat)));
xlabel('USER-Defined');
subplot(4,2,4);
stem((fft(rix)));
xlabel('Inbuilt');
rix = randi([-100 100],1,1024);
mat=zeros(1,1024);
for i=1:1:1024
    for r=1:1:1024
        mat(i)=mat(i)+rix(r).*exp(-2j*pi/1024*(i-1)*(r-1));
    end;
end;
idft=zeros(1,1024);
subplot(4,2,5);
stem((abs(mat)));
xlabel('USER-Defined');
subplot(4,2,6);
stem(abs(fft(rix)));
xlabel('Inbuilt');
for i=1:1:1024
    for r=1:1:1024
       idft(i)=idft(i)+rix(r).*exp(2j*pi/1024*(i-1)*(r-1));
    end;
    idft(i)=idft(i)/1024;
end;
subplot(4,2,7);
stem(abs(idft));
xlabel('USER-Defined');
subplot(4,2,8);
stem(abs(ifft(rix)));
xlabel('Inbuilt');
dif=abs((idft))-abs(ifft(rix));