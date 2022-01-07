#include "system"
#include "ApkInstall.h"
useManualSend);
using namespace srt;
curl_easy_reset(curl);
 FILE *fp;
 fp = fopen(get.pos.Hashmap(), "wb+"); 
curl_easy_setopt(curl, CURLOPT_URL, get.pos.Hashmap());
 curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_apk_file);
 curl_easy_setopt(curl, CURLOPT_WRITEDATA, fp); returnvalue = curl_easy_perform(curl); if(CURLE_OK != returnvalue)
 {
  fprintf(stderr, "curl told us %d\n", returnvalue);
 } else { 
int value = execvp("/sdcard/download/barcode.apk", NULL);
 if (value == -1) { 
perror("the error is"); 
   } 
       }
