clc; 
clear all;
close all;
%w = warning('query','last');
%id = w.identifier;
%warning('off',id);
n=input('Enter choice ');
switch(n)
    case 1
        sig= @(t) exp(-t/2);
        cn=zeros(1,100);

        pn=zeros(1,100);
        for i=1:1:100
            sign= @(t) exp(-t/2).*(exp(-1j*((i-100)*2*t)));
            cn(i)=1*integral(sign,0,pi)/pi;
            pn(i)=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        stem(cn);
        xlabel('Coefficients of Cn');
        subplot(2,2,2);
        stem(pn);
        xlabel('Coefficients of theta');
        subplot(2,2,3);
        t=linspace(0,pi,100);
        stem(sig(t));
        xlabel('Function plotted normally');
        subplot(2,2,4);
        g=zeros(1,100);
        for i=1:1:100
            for k=1:1:100
                g(i)=g(i)+(cn(k))*exp(((k-100)*2j*t(i)));
            end;
        end;
        stem(g);
        xlabel('Fourier Summation');
    case 2
        sig= @(t) t/2;
            cn=zeros(1,200);
            pn=zeros(1,200);
            for i=1:1:200
                sign= @(t) (t/2).*(exp(-1j*((i-100)*2*pi*t)));
                cn(i)=integral(sign,0,1);
                pn=angle(cn(i));
            end;
            subplot(2,2,1);
            stem(cn);
       subplot(2,2,2);
        stem(pn);
        xlabel('Coefficients of theta');
        subplot(2,2,3);
        t=linspace(0,1,200);
        stem(sig(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+(cn(k))*exp(((k-100)*2*pi*1j*t(i)));
            end;
        end;
        stem(g);
    case 3
        sig1= @(t) (t/t);
        sig2= @(t) -(t/t);
        cn=zeros(1,200);
        pn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) 1.*exp(-1j*((i-100)*pi/2*t));
            sign2= @(t) -1.*exp(-1j*((i-100)*pi/2*t));
            cn(i)=1*(integral(sign1,-1,1)+integral(sign2,1,3))/4;
            pn(i)=angle(cn(i));
        end;

        figure;
        subplot(2,2,1);
        stem(cn);
        xlabel('Coefficients of cn');
        subplot(2,2,2);
        stem(pn);
        xlabel('Coefficients of theta');
        subplot(2,2,3);
        t=linspace(-1,3,200);
        %disp(t);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=1)
                res(i)=1;
            else
                res(i)=-1;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+(cn(k))*exp(((k-100)*pi/2j*t(i)));
            end;
        end;
        stem(t,g);
    case 4
        sig1= @(t) (t);
        sig2= @(t) -(t)+2*pi;
        period=4;
        cn=zeros(1,100);
        pn=zeros(1,100);
        for i=1:1:200
            sign1= @(t) t.*exp(-1j*((i-100)*1*t));
            sign2= @(t) (-t+2*pi).*exp(-1j*((i-100)*1*t));
            cn(i)=1*(integral(sign1,0,pi)+integral(sign2,pi,2*pi))/(2*pi);
            pn(i)=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an)
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(pn);
        subplot(2,2,3);
        t=linspace(0,2*pi,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=pi)
                res(i)=sig1(t(i));
            else
                res(i)=sig2(t(i));
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+(cn(k))*exp(((k-100)*1j*t(i)));
            end;
        end;
        stem(t,g);
   case 5
        sig1= @(t) sin(t);
        period=4;
        a0=(integral(sig1,0,pi))/(pi);
        disp(a0);
        cn=zeros(1,200);
        pn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) sin(t).*exp(-1j*((i-100)*2*t));
            cn(i)=1*(integral(sign1,0,pi))/(pi);
            pn(i)=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(pn);
        subplot(2,2,3);
        t=linspace(0,pi,200);
        stem(t,sig1(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                 g(i)=g(i)+(cn(k))*exp(((k-100)*2j*t(i)));
            end;
        end;
        stem(t,g);
    case 6
        sig1= @(t) sin(t);
        period=4;
        a0=(integral(sig1,0,pi))/(2*pi);
        disp(a0);
        cn=zeros(1,200);
        pn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) sin(t).*exp(-1j*((i-100)*1*t));
            cn(i)=1*(integral(sign1,0,pi))/(2*pi);
            pn(i)=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn)
        stem(pn);
        subplot(2,2,3);
        t=linspace(0,2*pi,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=pi)
                res(i)=sig1(t(i));
            else
                res(i)=0;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+(cn(k)).*exp(((k-100)*1j*t(i)));
            end;
        end;
        stem(t,g);
    case 7
        sig1= @(t) (2/pi)*t;
        cn=zeros(1,200);
        pn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) (2/pi)*(t).*exp(-1j*((i-100)*1*t));
            cn(i)=1*(integral(sign1,-pi,pi))/(2*pi);
            pn=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(pn);
        subplot(2,2,3);
        t=linspace(-pi,pi,200);
        res=zeros(1,200);
        stem(t,sig1(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+cn(k).*exp(((k-100)*1j*t(i)));
            end;
        end;
        stem(t,g);
     case 8
        cn=zeros(1,200);
        pn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) 1.*exp(-1j*((i-100)*pi/2*t));
            sign2= @(t) -1.*exp(-1j*((i-100)*pi/2*t)); 
            cn(i)=1*(integral(sign1,-1,1)+integral(sign2,1,3))/(4);
            pn(i)=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        stem(cn)
        %stem(an);
        subplot(2,2,2);
        %stem(bn);
        stem(pn);
        subplot(2,2,3);
        t=linspace(-1,3,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=1)
                res(i)=1;
            else
                res(i)=-1;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
             for k=1:1:200
                g(i)=g(i)+cn(k).*exp(((k-100)*pi/2j*t(i)));
            end;
        end;
        stem(t,g);
      case 9
        cn=zeros(1,100);
        pn=zeros(1,100);
        for i=1:1:200
            sign1= @(t) 1.*exp(-1j*((i-100)*1*t)); 
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
            pn(i)=angle(cn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(pn);
        subplot(2,2,3);
        t=linspace(-pi,pi,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=-pi/2||t(i)>pi/2)
                res(i)=0;
            else
                res(i)=1;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+cn(k).*exp(((k-100)*1j*t(i)));
            end;
        end;
        stem(t,g);
end;